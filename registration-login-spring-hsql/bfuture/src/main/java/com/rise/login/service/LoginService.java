package com.rise.login.service;

import com.rise.login.dto.LoginRequest;
import com.rise.login.dto.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);
}

