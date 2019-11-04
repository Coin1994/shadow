# Action 说明

### 结构说明
```
@FunctionalInterface
public interface Action <T> {
    T apply(T data);
}
```


### 函数说明
```
// 一元函数接口 执行一个动作
T apply(T data);
```