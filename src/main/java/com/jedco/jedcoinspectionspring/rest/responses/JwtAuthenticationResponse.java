package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Set;

public record JwtAuthenticationResponse(String token, Set<String> authorities, boolean status, String name) {
}
