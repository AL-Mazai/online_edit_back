package com.back.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Access implements Serializable {

    private Integer accessId;

    private Integer docId;

    private Integer userId;

    private Integer accessLevel;

}
