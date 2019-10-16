package com.zhifei.blog.util;

import com.baidu.aip.contentcensor.AipContentCensor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 图片合格验证
 *
 * @author ZhiFei
 */
public class ImageDetect implements Runnable {
    private static final String APP_ID = "17243561";                                //APPID
    private static final String API_KEY = "RDcr26x1ERCSR1Gt9fV8qdWn";               //AK
    private static final String SECRET_KEY = "h8OGkPGMYTOS1TZwgG8KETYrgS1G0L1G";    //SK

    private byte[] image;

    private String key;

    public ImageDetect(byte[] image,String key){
        this.image=image;
        this.key=key;
    }

    public ImageDetect(){}

    /**
     * 图片内容审核
     *
     * @return
     */
    @Override
    public void run() {
        //内容审核
        AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);
        // 参数为本地图片文件二进制数组
        JSONObject response = client.imageCensorUserDefined(image, null);
        String conclusion = "合规";
        if (!response.get("conclusion").equals(conclusion)) {
            System.out.println("图片违规");
            System.out.println("key:"+key);
            UploadUtil.deleteFile(key);
        }
    }
}
