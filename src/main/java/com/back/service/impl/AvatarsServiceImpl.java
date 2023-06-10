package com.back.service.impl;


import com.back.mapper.AvatarsMapper;
import com.back.pojo.Avatars;
import com.back.service.AvatarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarsServiceImpl implements AvatarsService {

    @Autowired
    AvatarsMapper avatarsMapper;

    @Override
    public String getAvatarUrl(Integer userId) {
        return avatarsMapper.getAvatarUrl(userId);
    }

    @Override
    public boolean addAvatar(Avatars avatar) {
        if(avatarsMapper.addAvatar(avatar) > 0){
            return true;
        }
        return false;
    }
}




