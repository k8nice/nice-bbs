package com.nice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 通用实体类(创建时间和更新时间)
 *
 * @author nice
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past(message = "日期输入有误")
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past(message = "日期输入有误")
    private LocalDateTime gmtModify;
}
