package com.back.pojo;

import lombok.Data;

import java.io.Serializable;

import java.util.Date;

@Data
public class Document implements Serializable {

    private Integer docId;

    private String docName;

    private String docContent;

    private String type;

    private Date createdTime;

    private boolean status;


}
