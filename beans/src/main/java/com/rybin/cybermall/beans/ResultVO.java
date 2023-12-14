package com.rybin.cybermall.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private Integer code;
    private String msg;
    private Item data;
}
