package com.example.pickitup.service;

import com.example.pickitup.domain.dao.user.*;
import com.example.pickitup.domain.vo.Criteria;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.domain.vo.user.OrderVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ApplyDAO applyDAO;
    private final JjimDAO jjimDAO;
    private final LatestDAO latestDAO;
    private final OrderDAO orderDAO;
    private final UserDAO userDAO;




}
