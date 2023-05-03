package com.back.pojo;


import java.io.Serializable;

import java.util.Date;
import lombok.Data;

@Data
public class Version implements Serializable {

    private Integer versionId;

    private String versionNumber;

    private Date createdTime;

    private Integer docId;

}
