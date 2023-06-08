package com.back.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class Tools implements Serializable {

    private Integer toolId;

    private String logoLink;

    private String toolName;

    private String toolUrl;
}
