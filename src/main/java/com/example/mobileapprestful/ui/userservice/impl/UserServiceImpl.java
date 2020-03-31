package com.example.mobileapprestful.ui.userservice.impl;

import com.example.mobileapprestful.ui.model.request.UserDetailsRequestModel;
import com.example.mobileapprestful.ui.model.response.UserRest;
import com.example.mobileapprestful.ui.shared.Utils;
import com.example.mobileapprestful.ui.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    //  Temporary user data storage here
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);
        if (users == null)
            users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}
