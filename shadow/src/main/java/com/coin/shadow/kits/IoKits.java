package com.coin.shadow.kits;

import com.coin.shadow.func.Action;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @author ：孙伟
 * @date ：Created in 2019/10/10 14:58
 * @description：流处理工具
 * @modified By：孙伟
 * @version: v1.0.0.0
 */
public final class IoKits {

    /***
     * 禁止外部初始化
     */
    private IoKits(){
    }

    /***
     * 逐行读取字符内容
     * @param content
     * @return
     */
    public static String readContent(String content){
        String fileContent = "";
        if (StringUtils.isBlank(content)){
            return fileContent;
        }
        try {
            String lineContent = null;
            BufferedReader reader = new BufferedReader(new StringReader(content));
            while ((lineContent = reader.readLine()) != null){
                fileContent += lineContent;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public static String readContent(File file){
        String fileContent = "";
        if (file == null || !file.exists() || file.isFile()){
            return fileContent;
        }
        try {
            String lineContent = null;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((lineContent = reader.readLine()) != null){
                fileContent += lineContent;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }


    /***
     * 逐行读取字符内容
     * @param input
     * @return
     */
    public static String readContent(InputStream input){
        return readContent(input, null);
    }

    /***
     * 逐行读取字符内容
     * @param input
     * @param action
     * @return
     */
    public static String readContent(InputStream input, Action<String> action){
        String fileContent = "";

        if (ObjectKits.isNull(input)){
            return fileContent;
        }

        try {
            String lineContent = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            boolean flag = action != null;
            if (flag){
                while ((lineContent = reader.readLine()) != null){
                    fileContent += action.apply(lineContent);
                }
            }else {
                while ((lineContent = reader.readLine()) != null){
                    fileContent += lineContent;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }


    /**
     * 字节读取函数 返回字符，字符大于  Integer.MAX_VALUE 65535 报错
     * @param input
     * @return
     */
    public static String readAsString(InputStream input){
        byte[] bytes = read(input, DEFAULT_POOL_SIZE);
        return new String(bytes);
    }

    /***
     * 字节读取函数
     * @param input
     * @return
     */
    public static byte[] readAsByteArray(InputStream input){
        return read(input, DEFAULT_POOL_SIZE);
    }

    /***
     * 字节读取函数
     * @param input
     * @param size 缓存池大小
     * @return
     */
    public static byte[] read(InputStream input, int size){
        byte [] ret = new byte[0];
        if (ObjectKits.isNull(input)){
            return ret;
        }
        size = size <= 0 ? DEFAULT_POOL_SIZE : size;
        try{
            int len = -1;
            byte [] buf = new byte[size];
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            while ((len = input.read(buf)) != -1){
                output.write(buf, 0, len);
            }
            ret = output.toByteArray();
            output.flush();
            output.close();
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return ret;
    }



    private static final int DEFAULT_POOL_SIZE = 1024 * 4;
}
