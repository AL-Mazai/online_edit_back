package com.back.mapper;

import com.back.pojo.Avatars;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarsMapper {

    /**
     * 根据用户Id查找头像url
     * @param userId
     * @return
     */
    String getAvatarUrl(Integer userId);

    /**
     * 新增头像
     * @param avatar
     * @return
     */
    int addAvatar(Avatars avatar);
}




