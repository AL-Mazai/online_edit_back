package com.back.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteRecord implements Serializable {
    private Integer deleteId;

    private Integer userId;

    private Integer docId;


}