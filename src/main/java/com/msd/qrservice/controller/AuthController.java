package com.msd.qrservice.controller;

import com.msd.qrservice.dto.request.LoginRequest;
import com.msd.qrservice.dto.response.LoginResponse;
import com.msd.qrservice.exception.CustomException;
import com.msd.qrservice.service.UserService;
import com.msd.qrservice.utils.CustomErrorCodes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@ResponseStatus(HttpStatus.OK)
@Api(value = "Auth Controller")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;


    /**
     * Login API
     * @param loginRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    @ApiOperation(value = "User Login", response = LoginResponse.class)
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest)
            throws Exception {
        logger.info("Login endpoint called {}", loginRequest.getUsername());
        authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return userService.loginUser(loginRequest);
    }

    /**
     * Authenticate User
     * @param username
     * @param password
     * @throws Exception
     */
    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new CustomException(CustomErrorCodes.USER_DISABLED);
        } catch (BadCredentialsException e) {
            throw new CustomException(CustomErrorCodes.INVALID_CREDENTIALS);

        }

    }
}
