package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.exceptions.AuthenticationException;
import com.jedco.jedcoinspectionspring.models.RoleDefinition;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.models.UserAction;
import com.jedco.jedcoinspectionspring.repositories.RoleDefinitionRepository;
import com.jedco.jedcoinspectionspring.repositories.UserActionRepository;
import com.jedco.jedcoinspectionspring.repositories.UserRepository;
import com.jedco.jedcoinspectionspring.rest.requests.LoginRequest;
import com.jedco.jedcoinspectionspring.rest.responses.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleDefinitionRepository roleDefinitionRepository;
    private final UserActionRepository userActionRepository;

    @Override
    public JwtAuthenticationResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        } catch (org.springframework.security.core.AuthenticationException ex) {
            throw new AuthenticationException("Bad credentials!");
        }
        var user = usersRepository.findByUsername(request.username())
                .orElseThrow(() -> new AuthenticationException("Bad credentials!"));
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt, user.getFirstName(), toAuthoritySet(user), true, "Authentication Successful!");
    }

    @Override
    public JwtAuthenticationResponse refreshToken() {
        return null;
    }

    private Set<String> toAuthoritySet(User user) {
        Set<String> authorities = new HashSet<>();
        List<RoleDefinition> roleDefinitions = roleDefinitionRepository.findByUserRole(user.getUserRole());
        roleDefinitions.forEach(roleDefinition -> {
            UserAction action = userActionRepository.findById(roleDefinition.getUserAction().getId()).get();
            authorities.add(action.getAction());
        });
        return authorities;
    }
}
