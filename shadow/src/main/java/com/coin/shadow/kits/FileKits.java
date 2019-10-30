package com.coin.shadow.kits;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.Collections;
import java.util.List;

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
     * create 操作
     * @param directory
     * @param fileName
     * @return
     */
    public static File createFile(String directory,  String fileName){
        return createFile(String.format("%s%s", directory, fileName));
    }

    /***
     * create 操作
     * @param filePath
     * @return
     */
    public static File createFile(final String filePath){
        return createOrExitsFile(filePath);
    }
    /***
     * 创建一个目录
     * @param parent
     * @param child
     * @return
     */
    public static boolean createDirectory(String parent, String child){
        return createDirectory(String.format("%s%s", parent, child));
    }
    /***
     * 创建一个目录
     * @param directory
     * @return
     */
    public static boolean createDirectory(final String directory){
        return createOrExitsDirectory(checkDirectoryName(directory));
    }
    /***
     * remove 操作
     * @param directory
     * @param fileName
     * @return
     */
    public static boolean removeFile(String directory, String fileName){
        return removeFile(String.format("%s%s", checkDirectoryName(directory), fileName));
    }
    /***
     * remove 操作
     * @param path
     * @return
     */
    public static boolean removeFile(final String path){
        return removeFile(getFile(path));
    }
    /***
     * remove 操作
     * @param file
     * @return
     */
    public static boolean removeFile(final File file){
        return file != null && file.delete();
    }
    /***
     * 判断是否为文件
     * @param directory  文件夹路径
     * @param fileName    文件名称
     * @return
     */
    public static boolean isFile(String directory,  String fileName){
        return isFile(String.format("%s%s", checkDirectoryName(directory), fileName));
    }

    /***
     * 判断是否为文件
     * @param path
     * @return
     */
    public static boolean isFile(final String path){
        return isFile(new File(path));
    }

    /***
     * 判断是否为文件
     * @param file
     * @return
     */
    public static boolean isFile(final File file){
        return  file != null && file.exists() && file.isFile();
    }

    /***
     * 判断是否为文件夹
     * @param parent
     * @param child
     * @return
     */
    public static boolean isDirectory(String parent, String child){
        return isDirectory(String.format("%s%s", checkDirectoryName(parent), child));
    }

    /***
     * 判断是否为文件夹
     * @param directory
     * @return
     */
    public static boolean isDirectory(final String directory){
        return isDirectory(new File (directory));
    }

    /***
     * 判断是否为文件夹
     * @param file
     * @return
     */
    public static boolean isDirectory(final File file){
        return  file != null && file.exists() && file.isDirectory();
    }

    /***
     * 判断文件是否存在
     * @param directory 目录名称
     * @param fileName  文件名称
     * @return
     */
    public static boolean isExits(String directory,  String fileName){
        return isExits(String.format("%s%s", checkDirectoryName(directory), fileName));
    }
    /***
     * 判断文件是否存在
     * @param path
     * @return
     */
    public static boolean isExits(final String path){
        return isExits(new File(path));
    }
    /***
     * 判断文件是否存在
     * @param file
     * @return
     */
    public static  boolean isExits(final File file){
        return file != null && file.exists();
    }

    /***
     * 获取当前目录下的目录(找一层)
     * @return
     */
    public static List<File> getDirectories(String directory){
        directory = checkDirectoryName(directory);
        File target = getFile(directory);
        if (!isDirectory(target)){
            return CollectionsKits.emptyList();
        }
        List<File> ret = Lists.newArrayList();
        for (File file : target.listFiles()) {
            if (isDirectory(file)){
                ret.add(file);
            }
        }
        return ret;
    }

    /***
     * 获取当前目录下的文件 （找一层）
     * @return
     */
    public static List<File> getFiles(String directory){
        directory = checkDirectoryName(directory);
        File target = getFile(directory);
        if (!isDirectory(target)){
            return CollectionsKits.emptyList();
        }
        List<File> ret = Lists.newArrayList();
        for (File file : target.listFiles()) {
            if (isFile(file)){
                ret.add(file);
            }
        }
        return ret;
    }

    /***
     * 获取当前目录下的文件名称 （找一层）
     * @return
     */
    public static List<String> getFileNames(String directory){
        directory = checkDirectoryName(directory);
        File target = getFile(directory);
        if (!isDirectory(target)){
            return CollectionsKits.emptyList();
        }

        List<String> ret = Lists.newArrayList();
        for (File file : target.listFiles()) {
            if (isFile(file)){
                ret.add(file.getPath());
            }
        }
        return ret;
    }

    /**
     * 检查传入目录路径
     * @param directory
     * @return
     */
    private static String checkDirectoryName(String directory){
        String lastString = StringKits.lastString(directory);
        if (!lastString.equalsIgnoreCase("/")){
            directory += "/";
        }
        return directory;
    }

    /**
     * 获取一个文件
     * @param path
     * @return
     */
    private static File getFile(String path){
        return StringKits.isBlank(path) ? null : new File(path);
    }
    /***
     * 创建或者返回一个已存在的文件
     * @param path
     * @return
     */
    private static File createOrExitsFile(final String path){
        if (StringKits.isBlank(path)){
            return null;
        }
        File file = new File(path);
        if (isFile(file)){
            return file;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /***
     * 创建或者返回一个已存在的文件
     * @param path
     * @return
     */
    private static boolean createOrExitsDirectory(final String path){
        if (StringKits.isBlank(path)){
            return false;
        }
        File file = new File(path);
        if (isDirectory(file)){
            return true;
        }
        return file.mkdir();
    }

    private static boolean copyOrMoveFile(File src, File dest, boolean isMove){
        if (!isFile(src) || !isFile(dest)){
            return false;
        }
        if (isMove){
            if (writeFile(src, dest,false)){
                return removeFile(src);
            }
        }else {
            return writeFile(src, dest,false);
        }
        return false;
    }
    private static boolean writeFile(File src,  File dest, boolean append){
        try {
            return IoKits.writeFile(dest, new FileInputStream(src),1024 * 4 * 2, append);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    private static boolean writeFile(File dest, InputStream input, boolean append){
        return IoKits.writeFile(dest,input,1024 * 4 * 2, append);
    }

    public static void main(String argc[]){
        File file = new File("D:/github/note/blog/hello.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
    }
}
