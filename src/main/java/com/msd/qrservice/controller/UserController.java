package com.msd.qrservice.controller;

import com.msd.qrservice.dto.request.UserRequest;
import com.msd.qrservice.dto.response.UserResponse;
import com.msd.qrservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(value = "User Controller")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * Create User API
     * @param userRequest
     * @return
     * @throws Exception
     */
    @PostMapping
    @ApiOperation(value = "Create User", response = UserResponse.class)
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
            throws Exception {
        logger.info("User Create endpoint called ");
        return ResponseEntity.ok(userService.createUser(userRequest));
    }
}
