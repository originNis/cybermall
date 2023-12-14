package com.rybin.cybermall.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private Integer itemId;
    private String description;
    private Double price;
    private String imgurl;
}
