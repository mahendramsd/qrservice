package com.msd.qrservice.service;

import com.msd.qrservice.config.SecurityConfig;
import com.msd.qrservice.domain.CustomUserDetail;
import com.msd.qrservice.domain.Role;
import com.msd.qrservice.domain.User;
import com.msd.qrservice.dto.enums.Status;
import com.msd.qrservice.dto.request.LoginRequest;
import com.msd.qrservice.dto.request.UserRequest;
import com.msd.qrservice.dto.response.LoginResponse;
import com.msd.qrservice.dto.response.UserResponse;
import com.msd.qrservice.exception.CustomException;
import com.msd.qrservice.repositories.RoleRepository;
import com.msd.qrservice.repositories.UserRepository;
import com.msd.qrservice.utils.CustomErrorCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    /**
     * Create New User
     *
     * @param userRequest
     * @return
     */
    public UserResponse createUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findByUsername(userRequest.getUsername());
        if (user.isPresent()) {
            logger.debug("User Name already exist :: {}", userRequest.getUsername());
            throw new CustomException(CustomErrorCodes.USER_ALREADY_EXIST);
        } else {
            User newUser = new User();
            newUser.setUsername(userRequest.getUsername());

            Optional<Role> role = roleRepository.findById(userRequest.getRoleId());
            if (role.isPresent()) {
                newUser.setRole(role.get());
                newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
                userRepository.save(newUser);
                logger.debug("User Created, UserName :: {}", newUser.getUsername());
                return new UserResponse(newUser);
            } else {
                logger.debug("User Role Not Found :: {}", userRequest.getRoleId());
                throw new CustomException(CustomErrorCodes.USER_ROLE_NOT_FOUNT);
            }
        }
    }

    /**
     * Find Custom User details
     *
     * @param username
     * @return
     */
    public CustomUserDetail findByCustomUserDetail(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new CustomUserDetail(user.get());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    /**
     * Find Active User
     *
     * @param username
     * @param jwtToken
     * @return
     */
    public Optional<User> findByActiveUser(String username, String jwtToken) {
        return userRepository.findByUsernameAndAccessToken(username, jwtToken);
    }

    /**
     * Login User
     *
     * @param loginRequest
     * @return
     */
    public LoginResponse loginUser(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUsernameAndStatus(loginRequest.getUsername(), Status.ACTIVE);
        if (user.isPresent()) {
            user.get().setAccessToken(securityConfig.generateToken(user.get().getUsername()));
            userRepository.save(user.get());
            logger.debug("Token Updated :: {}", user.get().getUsername());
            return new LoginResponse(user.get());
        } else {
            throw new CustomException(CustomErrorCodes.USER_NOT_FOUND);
        }
    }
}
