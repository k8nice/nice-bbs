package com.nice.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;
}
