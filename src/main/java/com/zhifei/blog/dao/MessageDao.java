package com.zhifei.blog.dao;

import org.apache.ibatis.annotations.Param;
import com.zhifei.blog.entity.Message;

import java.util.List;

/**
 * @author ZhiFei
 */
public interface MessageDao {

    /**
     * 提交留言
     * @param message
     */
    void serMessage(@Param("message") Message message);

    /**
     * 获取所有留言
     * @return
     */
    List<Message> getAllMessage();
}
