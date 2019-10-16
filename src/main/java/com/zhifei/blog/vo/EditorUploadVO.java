package com.zhifei.blog.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EditorUploadVO {
    private int errno;
    List<String> data;

    public EditorUploadVO(){
        this.data=new ArrayList<>();
    }
}
