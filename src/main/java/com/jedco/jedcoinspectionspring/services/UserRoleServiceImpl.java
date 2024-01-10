package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.UserRoleUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserRoleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    @Override
    public ResponseDTO userRoleUpdate(UserRoleUpdateRequest userRoleUpdateDto) {
        return null;
    }

    @Override
    public List<UserRoleResponse> userRoleList() {
        return null;
    }
}
