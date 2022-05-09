package com.msd.qrservice.controller;

import com.msd.qrservice.dto.request.LoginRequest;
import com.msd.qrservice.dto.response.LoginResponse;
import com.msd.qrservice.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {

    @InjectMocks
    AuthController authController;

    @Mock
    private UserService userService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Test
    public void authenticateUserTest(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("mahendra");
        loginRequest.setPassword("123456");
        LoginResponse loginResponse = new LoginResponse();
        Mockito.when(userService.loginUser(loginRequest)).thenReturn(loginResponse);
        Assert.assertEquals(loginResponse, authController.authenticateUser(loginRequest).getBody().getData());
    }
}
