package com.rybin.cybermall.mapper;

import com.rybin.cybermall.beans.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelfMapper {
    @Select("""
        SELECT item_id, description, price FROM items
        WHERE item_id = #{id}
    """)
    public Item getItemById(int id);
}
