package com.back.pojo;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

@Data
public class Document implements Serializable {

    private Integer docId;

    private String docName;

    private String type;

    private Date createdTime;

    /**
     * 1表示可编辑，0表示不可编辑
     */
    private boolean status;

    /**
     * 1表示未删除，0表示已被删除
     */
    private int isDelete;
}
