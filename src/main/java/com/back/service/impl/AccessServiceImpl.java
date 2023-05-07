package com.back.service.impl;

import com.back.mapper.AccessMapper;
import com.back.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessMapper accessMapper;

    @Override
    public boolean deleteUserOfDoc(Integer userId, Integer docId) {
        if (accessMapper.deleteUserOfDoc(userId, docId) > 0) {
            return true;
        }
        return false;
    }
}
