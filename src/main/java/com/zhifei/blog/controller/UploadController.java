package com.zhifei.blog.controller;

import com.zhifei.blog.entity.User;
import com.zhifei.blog.util.ImageDetect;
import com.zhifei.blog.util.UploadUtil;
import com.zhifei.blog.vo.EditorUploadVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZhiFei
 */
@Controller
public class UploadController {
    @Autowired
    private ThreadPoolExecutor executor;
    @Resource
    private RedisTemplate<String, Object> template;
    /**
     * 上传博客图片
     *
     * @return
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public EditorUploadVO upload(@RequestParam("file") MultipartFile file) throws IOException, JSONException, ExecutionException, InterruptedException {
        //获取Session中的用户信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        //返回给前端的数据
        EditorUploadVO data = new EditorUploadVO();
        //文件上传
        String key = UploadUtil.uploadFile(file.getInputStream());
        //key缓存到Redis中
        if(!template.opsForHash().hasKey("uploadFile",user.getUserId().toString())){
            template.opsForHash().put("uploadFile",user.getUserId().toString(),new ArrayList<>());
        }
        @SuppressWarnings("unchecked")
        List<String> list = (List<String>)template.opsForHash().get("uploadFile",user.getUserId().toString());
        list.add(key);
        //图片内容审核
        executor.execute(new ImageDetect(file.getBytes(),key));
        //状态默认为0.成功
        data.setErrno(0);
        //上传文件路径
        data.getData().add(UploadUtil.prefix + key);
        return data;
    }

}
