package com.zhifei.blog.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.InputStream;

/**
 * @author ZhiFei
 */
public class UploadUtil {
    private static final Configuration cfg = new Configuration(Zone.zone2());    //构造一个带指定Zone对象的配置类
    private static final UploadManager uploadManager = new UploadManager(cfg);
    private static final String accessKey = "Ww_wMMRAADP9JP7uU7IQjLCaaice1exuBCiROe2Z";
    private static final String secretKey = "EJDeU1XyK1tiA-gAWoUyDWnoJ0oGRo3_pQD4aq9k";
    private static final String bucket = "zhifei-blog";    //bucket名
    private static final String key = null;    //默认不指定key的情况下，以文件内容的hash值作为文件名
    private static final Auth auth = Auth.create(accessKey, secretKey);
    public static final String prefix = "http://cloud.wanzhifei.com/";

    /**
     * 上传文件，并返回地址
     * @param file
     * @return
     */
    public static String uploadFile(InputStream file){
        String upToken = auth.uploadToken(bucket);
        try {
            //文件上传
            Response response = uploadManager.put(file, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            //返回文件名
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    /**
     * 删除文件
     *
     * @param key
     * @return
     */
    public static void deleteFile(String key){
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }

    /**
     * 批量删除文件
     *
     * @param keyList
     */
    public static void batchRemove(String[] keyList) {
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
            batchOperations.addDeleteOp(bucket, keyList);
            Response response = bucketManager.batch(batchOperations);
            BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);
            for (int i = 0; i < keyList.length; i++) {
                BatchStatus status = batchStatusList[i];
                String key = keyList[i];
                System.out.print(key + "\t");
                if (status.code == 200) {
                    System.out.println("delete success");
                } else {
                    System.out.println(status.data.error);
                }
            }
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
        }
    }
}