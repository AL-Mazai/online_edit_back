package com.back.pojo;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

@Data
public class Document implements Serializable {

    private Integer docId;

    private String docName;

    private String docContent;

    private String type;

    private Date createdTime;

    private boolean status;

    //多对多的映射关系：一个文档可由多个用户编辑
    private List<User> userList;
}
