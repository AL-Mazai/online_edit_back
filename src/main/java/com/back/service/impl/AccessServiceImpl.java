package com.back.service.impl;

import com.back.mapper.AccessMapper;
import com.back.pojo.Access;
import com.back.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessMapper accessMapper;

    @Override
    public boolean inviteUserOfDoc(Access access) {
        if(accessMapper.insertUserOfDoc(access) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserOfDoc(Integer userId, Integer docId) {
        if (accessMapper.deleteUserOfDoc(userId, docId) > 0) {
            return true;
        }
        return false;
    }
}
