package com.back.mapper;


import com.back.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{
    public List<User> getAllUser();
}
