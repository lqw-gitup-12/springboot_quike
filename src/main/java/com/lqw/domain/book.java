package com.lqw.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

@Data
public class book {
    //@TableId(value = "id")
    private Integer  id;
    private  String  type;
    private  String name;
    private  String description;


    public book(String type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public book() {
    }

    public book(Integer id, String type, String name, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
