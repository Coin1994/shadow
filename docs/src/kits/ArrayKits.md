# ArrayKits 说明
数组处理小工具

### 结构说明
```
public final class ArrayKits {
    /***
     * 禁止外部初始化
     */
    private ArrayKits(){
    }
}
```
### 函数说明
#### 判断数组是否为空
```
// 定义：
public static boolean isEmpty(final Object[] array){
    ...
}

// 用例：
bool flag = ArrayKits.isEmpty(array);
if(flag){
    ...
}else{
    ...
}
```
#### 获取数组长度
```
// 定义：
public static int length(final Object[] array){
    ...
}

// 用例：
int len = ArrayKits.length(array);
```
