package com.msd.qrservice.controller;

import com.msd.qrservice.dto.request.UserRequest;
import com.msd.qrservice.dto.response.UserResponse;
import com.msd.qrservice.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    private UserService userService;


    @Test
    public void createUserTest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("mahendra");
        userRequest.setPassword("123456");
        userRequest.setRoleId(1);
        UserResponse userResponse = new UserResponse();
        Mockito.when(userService.createUser(userRequest)).thenReturn(userResponse);
        Assert.assertEquals(userResponse, userController.createUser(userRequest).getBody().getData());
    }
}
