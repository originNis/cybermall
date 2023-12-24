package com.rybin.cybermall.beans.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
