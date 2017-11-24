package com.rise.registration.service;

import com.rise.registration.dto.RegistrationRequest;
import com.rise.registration.dto.RegistrationResponse;

public interface RegistrationService {

    RegistrationResponse register(RegistrationRequest registrationRequest);
}
