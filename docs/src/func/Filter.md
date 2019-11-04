# Filter 说明

### 结构说明
```
@FunctionalInterface
public interface Filter<T> {
    boolean apply(T data);
}

```

### 函数说明
```
// 一元函数接口 执行一个过滤
boolean apply(T data);
```