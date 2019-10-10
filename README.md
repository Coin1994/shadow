# shadow —— java通用工具集  
### 编码规范  
##### 1: shadow 采用 c++ 的编码方式。即:类的成员变量统一写在函数定义之后，算是一个编码习惯。
```
class A {
    // 方法
    public void method(){
        ...
    }
    // 成员变量
    private int a;
}
```
##### 2: shadow 提供了一组工具类集合。工程内提供的都为静态方法。鄙人认为不需要在外部以new的形式出现，故而禁用了构造函数  
```
public final class A {
    /***
     * 禁止外部初始化
     */
    private A(){
    }
}
```
### 项目依赖  
##### 1: shadow 采用 maven 的方式组织工程。仅仅依赖 [guava],[commons-lang3],[lombok]...
```        
    <lombok.version>1.18.10</lombok.version>
    <guava.version>27.0-jre</guava.version>
    <commons-lang3.version>3.8</commons-lang3.version>
    ...
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${lombok.version}</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.google.guava</groupId>
        <artifactId>guava</artifactId>
        <version>${guava.version}</version>
    </dependency>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>${commons-lang3.version}</version>
    </dependency>
    ...
```
### 项目结构
```
    shadow
        // 存放一些基础工具，与业务逻辑无关
        com.coin.shadow.kits
        // 存放一些基础工具，与业务逻辑有关
        com.coin.shadow.utils
```  