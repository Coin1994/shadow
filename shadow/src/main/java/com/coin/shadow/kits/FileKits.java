package com.coin.shadow.kits;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/10 9:58
 * @description：文件处理小工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class FileKits {
    /***
     * 禁止外部初始化
     */
    private FileKits(){
    }

    /***
     * 判断是否为文件
     * @param directoryPath  文件夹路径
     * @param fileName    文件名称
     * @return
     */
    public static boolean isFile(String directoryPath,  String fileName){
        if (StringUtils.isBlank(directoryPath)){
            throw new RuntimeException("目录路径不正确");
        }
        int length = directoryPath.length();
        if (!directoryPath.substring(length - 1).equalsIgnoreCase("/")){
            directoryPath = directoryPath + "/";
        }
        return isFile(String.format("%s%s", directoryPath, fileName));
    }

    /***
     * 判断是否为文件
     * @param filePath
     * @return
     */
    public static boolean isFile(final String filePath){
        if (StringUtils.isBlank(filePath)){
            return false;
        }
        File file = new File(filePath);
        return file.isFile();
    }

    /***
     * 判断是否为文件夹
     * @param directoryPath
     * @return
     */
    public static boolean isDirectory(final String directoryPath){
        if (StringUtils.isBlank(directoryPath)){
            return false;
        }
        File file = new File(directoryPath);
        return file.isDirectory();
    }

    public static File createFile(String directoryPath,  String fileName){
        return null;
    }
}
