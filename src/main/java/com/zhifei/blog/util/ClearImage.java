package com.zhifei.blog.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

/**
 * 清理上传但未提交的图片
 *
 * @author ZhiFei
 */
public class ClearImage {

    @Resource
    private RedisTemplate<String, Object> template;

    /**
     * 添加定时任务
     */
    @Scheduled(cron = "0 0 3 * * ? ")
    private void configureTasks() {
        List<Object> list = template.opsForHash().values("uploadFile");
        String[] keyList = new String[list.size()];
        keyList=list.toArray(new String[0]);
        UploadUtil.batchRemove(keyList);
        template.opsForHash().delete("uploadFile",template.opsForHash().keys("uploadFile"));
    }
}
