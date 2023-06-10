package com.back.pojo;

import lombok.Data;
import java.io.Serializable;

@Data
public class Avatars implements Serializable {
    private Integer userId;

    private String avatarUrl;

}
