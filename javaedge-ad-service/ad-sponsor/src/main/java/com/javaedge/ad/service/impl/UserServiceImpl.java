package com.javaedge.ad.service.impl;

import com.javaedge.ad.constant.Constants;
import com.javaedge.ad.dao.AdUserRepository;
import com.javaedge.ad.entity.AdUser;
import com.javaedge.ad.exception.AdException;
import com.javaedge.ad.service.IUserService;
import com.javaedge.ad.utils.CommonUtils;
import com.javaedge.ad.vo.CreateUserRequest;
import com.javaedge.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sss
 * @date 2019/2/5
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        //校验参数
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        //判断同名用户存在
        AdUser oldUser = userRepository.findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        // 开始创建用户
        AdUser newUser = userRepository.save(new AdUser(request.getUsername(), CommonUtils.md5(request.getUsername())
        ));

        return new CreateUserResponse(newUser.getId(), newUser.getUsername(), newUser.getToken(), newUser.getCreateTime(), newUser.getUpdateTime());

    }

}

