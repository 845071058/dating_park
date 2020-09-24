package com.enjoy.dating_park.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 需要进行排序的字段
     */
    @ApiModelProperty("字段名称")
    private String column;

    /**
     * 是否正序排列，默认 true
     */
    @ApiModelProperty("是否正序")
    private boolean asc = true;


}
