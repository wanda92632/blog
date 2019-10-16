package com.zhifei.blog.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    /**
     * 处理缩略图
     * @param thumbnailInputStream
     * @param targetAddr
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName,String targetAddr) {
        //获取随机文件名
        String realFileName = getRandomFileName();
        //获取文件扩展名
        String extension = getFileExtension(fileName);
        //创建文件夹
        makeDirPath(targetAddr);
        //写入文件名及地址
        String relativeAddr = targetAddr + realFileName + extension;
        //文件
        File dest = new File(PathUtil.getImageBasePath() + relativeAddr);
        try {
            //生成文件
            Thumbnails.of(thumbnailInputStream).size(200, 200).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        relativeAddr = relativeAddr.replace("\\","/");
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/xxx/xxx,jpg
     * 那么 home work xxx 这三个文件夹都得自动创建,
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParenPath = PathUtil.getImageBasePath() + targetAddr;
        File dirPath = new File(realFileParenPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     *
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     *
     * @return
     */
    private static String getRandomFileName() {
        //获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

}
