# day5

## 计划

1. HTML入门基础学习

## 笔记

### 1.HTML基础结构

1. **文档声明**：`<!DOCTYPE html>`，声明文件类型为HTML5
2. **根元素**：`<html>`，包含整个HTML文档
3. **头部**：`<head>`，存放页面元信息
    - `<title>`：页面标题，显示在浏览器标签栏
    - `<meta>`：元数据，如字符集`<meta charset="UTF-8">`、视口设置`<meta name="viewport">`
    - `<style>`：内部样式表
    - `<link>`：引入外部样式表
4. **主体**：`<body>`，页面可见内容区域

### 2.常用HTML标签

##### 文本标签
1. `<h1>-<h6>`：标题标签，h1最大，h6最小
2. `<p>`：段落标签
3. `<span>`：行内容器，不换行
4. `<div>`：块级容器，独占一行
5. `<b>`：加粗文本

##### 媒体标签
1. `<img>`：图片标签
    - `src`：图片路径（相对路径如`./img/1.png`或绝对路径）
    - `alt`：图片加载失败时的替代文本
2. `<video>`：视频标签
    - `src`：视频路径
    - `controls`：显示播放控制条

##### 链接标签
1. `<a>`：超链接标签
    - `href`：目标URL
    - `target="_blank"`：在新窗口打开

### 3.CSS样式

##### 三种引入方式
1. **行内样式**：通过标签的`style`属性直接设置，优先级最高
    ```html
    <span style="color: red;">红色文字</span>
    ```
2. **内部样式**：在`<style>`标签内定义，作用于当前页面
3. **外部样式**：通过`<link>`标签引入外部CSS文件，可复用
    ```html
    <link rel="stylesheet" href="css/test01.css">
    ```

##### CSS选择器
1. **元素选择器**：直接使用标签名，选中所有该标签
    ```css
    span { color: red; }
    ```
2. **类选择器**：使用`.类名`，可选中多个元素（类名可重复）
    ```css
    .time { color: #b7b7b7; }
    ```
3. **ID选择器**：使用`#ID名`，只能选中一个元素（ID唯一）
    ```css
    #a001 { text-decoration: none; }
    ```

### 4.盒子模型

1. **核心概念**：每个元素都是一个盒子，由内容(content)、内边距(padding)、边框(border)、外边距(margin)组成
2. **box-sizing**：控制盒子尺寸计算方式
    - `content-box`（默认）：width/height仅包含内容
    - `border-box`：width/height包含内容+内边距+边框，便于布局计算
3. **margin**：外边距，控制元素间距
    - `margin: 0 auto;`：上下边距为0，左右自动，实现块级元素居中

### 5.Flexbox弹性布局

1. **开启方式**：父元素设置`display: flex;`
2. **主轴方向**：`flex-direction`
    - `row`（默认）：水平方向
    - `column`：垂直方向
3. **主轴对齐**：`justify-content`
    - `space-between`：两端对齐，项目之间间距相等
    - `center`：居中对齐
    - `space-around`：均匀分布，项目两侧间距相等
4. **交叉轴对齐**：`align-items`
    - `center`：垂直居中
    - `flex-start`：顶部对齐
    - `flex-end`：底部对齐

### 6.表单与表单项

##### 表单结构
1. `<form>`：表单容器
    - `action`：提交地址
    - `method`：提交方式（get/post）

##### 表单项类型

1. **文本输入类**
    - `text`：单行文本
    - `password`：密码输入（隐藏内容）
    - `email`：邮箱输入（自动验证格式）
    - `tel`：电话输入
    - `url`：网址输入
    - `textarea`：多行文本

2. **数字输入类**
    - `number`：数字输入（带上下箭头）
    - `range`：范围滑块

3. **日期时间类**
    - `date`：日期选择器
    - `time`：时间选择器

4. **选择类**
    - `select`：下拉列表（配合`<option>`使用）
    - `radio`：单选按钮（同一组name相同，互斥）
    - `checkbox`：复选框（可多选）

5. **文件上传**
    - `file`：文件选择，`multiple`属性支持多文件

6. **按钮类**
    - `submit`：提交表单
    - `reset`：重置表单
    - `button`：普通按钮

### 7.表格

1. `<table>`：表格容器
2. `<thead>`：表头区域
3. `<tbody>`：表体区域
4. `<tr>`：表格行
5. `<th>`：表头单元格（默认加粗居中）
6. `<td>`：表格数据单元格
7. **边框合并**：`border-collapse: collapse;`

### 8.综合页面实践

1. **页面布局**：使用`div`划分区域（导航栏、内容区、页脚）
2. **响应式设置**：`<meta name="viewport">`适配移动端
3. **样式优先级**：行内样式 > ID选择器 > 类选择器 > 元素选择器
4. **常用CSS属性**
    - `text-indent: 2em;`：首行缩进2个字符
    - `line-height`：行高
    - `text-decoration: none;`：取消下划线
    - `border-radius`：圆角
    - `cursor: pointer;`：鼠标悬停显示手型
    - `transition`：过渡动画效果