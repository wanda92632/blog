package com.zhifei.blog.util;

/**
 * @author ZhiFei
 */
public class PathUtil {
    /**
     * 获取文件分隔符
     */
    private static String seperator = System.getProperty("file.separator");

    /**
     * 返回项目图片根路径
     * @return
     */
    public static String getImageBasePath(){
        String os = System.getProperty("os.name");
        String basePath;
        if(os.toLowerCase().startsWith("win")){
            basePath = "C:/projectDev/image/";
        }
        else
        {
            basePath="/home/projectDev/image/";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    /**
     * 返回项目图片子路径
     * @param userId
     * @return
     */
    public static String getShopImagePath(String userId){
        String imagePath = "upload/item/user/"+userId+"/";
        return imagePath.replace("/",seperator);
    }
}
