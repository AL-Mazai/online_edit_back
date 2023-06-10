package com.back.service;

import com.back.pojo.Avatars;

public interface AvatarsService{

    /**
     * 获取头像Url
     * @param userId
     * @return
     */
    String getAvatarUrl(Integer userId);

    /**
     * 新增头像
     * @param avatar
     * @return
     */
    boolean addAvatar(Avatars avatar);
}
