package com.kevinlyz.provider.service;

import com.kevinlyz.api.kevinapi.api.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * 用户服务
 * 
 * @author kevinlyz
 * @version 1.0
 * @date 2020-02-26 19:37
 */
@Slf4j
@Service
public class UserService implements IUserService {


    @Override
    public String getUserInfo(String userId) {
        return userId;
    }
}
