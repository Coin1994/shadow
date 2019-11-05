# ByteKits 说明
字节处理小工具

### 结构说明
```
public final class ByteKits {
    /***
     * 禁止外部初始化
     */
    private ByteKits(){
    }
}
```
### 函数说明
#### 字符串转字节数组
```
// 定义：
public static byte[] stringToByteArray(final String data){
    ...
}

// 用例：
byte[] buf = ByteKits.stringToByteArray(str);
```
#### 字节数组转字符串
```
// 定义：
public static String byteArrayToString(final byte[] data){
    ...
}

// 用例：
string str = ByteKits.byteArrayToString(bytes);
```
