# day7

## 计划

1. Maven项目构建与管理入门

## 笔记

### 1.Maven概述

1. **作用**：项目构建、依赖管理、项目信息管理
2. **核心概念**：基于项目对象模型（POM），通过`pom.xml`管理项目

### 2.Maven项目结构

```
maven-project01/
├── pom.xml                 # Maven核心配置文件
├── src/
│   ├── main/
│   │   └── java/           # 主代码目录
│   │       └── com/zhang/  # 包结构
│   │           ├── helloworld.java
│   │           └── UserService.java
│   └── test/
│       └── java/           # 测试代码目录
│           └── com/zhang/
│               └── UserServiceTest.java
└── target/                 # 编译输出目录（自动生成）
```

### 3.POM配置

##### 项目坐标
1. `groupId`：组织标识（如`org.example`）
2. `artifactId`：项目标识（如`maven-project01`）
3. `version`：版本号（如`1.0-SNAPSHOT`）

##### 编译属性
```xml
<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```

##### 引入依赖
1. 在`<dependencies>`中添加`<dependency>`标签
2. 依赖组成：groupId + artifactId + version
3. **依赖范围（scope）**：控制依赖的使用范围
    - `test`：仅在测试时使用，打包时不包含
    - `compile`（默认）：编译、测试、运行都有效
    - `provided`：编译和测试时有效，运行时由容器提供
    - `runtime`：运行时有效，编译时不需要
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.1</version>
    <scope>test</scope>
</dependency>
```

### 4.单元测试（JUnit 5）

##### 基础注解
1. `@Test`：标记一个方法为测试方法
2. `@DisplayName`：为测试方法添加中文描述名称，便于阅读
3. `@BeforeAll`：在所有测试方法执行前执行一次（静态方法）
4. `@AfterAll`：在所有测试方法执行后执行一次（静态方法）
5. `@BeforeEach`：每个测试方法执行前都执行一次
6. `@AfterEach`：每个测试方法执行后都执行一次

##### 参数化测试

1. `@ParameterizedTest`：标记参数化测试方法
2. `@ValueSource(strings = {"数据1", "数据2"})`：提供参数列表
3. 方法参数接收传入的测试数据，自动执行多次测试

##### 常用断言

1. `Assertions.assertEquals(预期值, 实际值, "失败提示信息")`：判断两个值是否相等
2. `Assertions.assertThrows(异常类型, 可执行代码)`：判断是否抛出指定异常

### 5.测试示例

##### 业务方法（UserService）
1. **getAge(idCard)**：从身份证号中提取出生日期（第7-14位），计算年龄
    ```java
    public Integer getAge(String idCard) {
        String birthday = idCard.substring(6, 14);
        LocalDate parse = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Period.between(parse, LocalDate.now()).getYears();
    }
    ```
2. **getGender(idCard)**：从身份证号中提取第17位，奇数为男，偶数为女
    ```java
    public String getGender(String idCard) {
        return Integer.parseInt(idCard.substring(16, 17)) % 2 == 1 ? "男" : "女";
    }
    ```

##### 测试方法
1. **单个测试**：使用`@Test`，调用方法后打印或断言结果
2. **参数化测试**：使用`@ParameterizedTest` + `@ValueSource`，批量测试多组数据
3. **异常测试**：使用`assertThrows`验证非法输入时是否抛出预期异常
4. **断言验证**：使用`assertEquals`判断方法返回结果是否符合预期
