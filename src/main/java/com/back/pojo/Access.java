package com.back.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Access implements Serializable {

    private Integer accessId;

    private Integer docId;

    private Integer userId;

    /**
     * 权限等级：1表示创建者，2表示可编辑查看，3表示无法编辑查看
     */
    private Integer accessLevel;

}
