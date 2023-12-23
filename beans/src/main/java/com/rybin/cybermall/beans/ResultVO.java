package com.rybin.cybermall.beans;

import com.rybin.cybermall.beans.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;
}
