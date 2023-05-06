package com.back.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String password;
    private String email;
    //多对多的映射关系：一个用户可以参与多个文档的编辑
    private List<Document> documentList;
}
