package com.example.mobileapprestful.ui.userservice;

import com.example.mobileapprestful.ui.model.request.UserDetailsRequestModel;
import com.example.mobileapprestful.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
