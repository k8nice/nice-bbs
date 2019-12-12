package com.nice.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通用实体类(创建时间和更新时间)
 * @author nice
 */
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
