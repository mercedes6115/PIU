package com.example.pickitup.service;

import com.example.pickitup.domain.dao.user.ApplyDAO;
import com.example.pickitup.domain.dao.user.CompanyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ApplyDAO applyDAO;
    private final CompanyDAO companyDAO;
}
