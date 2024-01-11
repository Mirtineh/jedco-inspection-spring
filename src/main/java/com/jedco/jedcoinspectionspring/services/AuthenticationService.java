package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.LoginRequest;
import com.jedco.jedcoinspectionspring.rest.responses.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse login(LoginRequest request);

    JwtAuthenticationResponse refreshToken();
}
