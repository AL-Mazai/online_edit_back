package com.back.pojo;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Comment implements Serializable {

    private Integer commentId;

    private String commentDescription;

    private Date commentTime;

    private Integer userId;

    private Integer docId;

}
