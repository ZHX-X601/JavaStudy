# day6

## 计划

1. JS基础语法学习
2. Vue3框架入门

## 笔记

### 1.JS引入方式

1. **内联式**：直接在`<script>`标签内编写代码，写在`body`底部避免DOM未加载完成
    ```html
    <script>
      alert('hello world');
    </script>
    ```
2. **外部式**：通过`src`属性引入外部JS文件，利于代码复用和维护
    ```html
    <script src="./JS/hello.js"></script>
    ```

### 2.JS基础语法

##### 变量
1. `let`：声明可变变量
2. `const`：声明常量，声明后不可修改
3. `typeof`：获取变量类型

##### 函数
1. **普通函数**：使用`function`关键字定义
    ```javascript
    function add(a, b) {
      return a + b;
    }
    ```
2. **匿名函数**：没有函数名，可赋值给变量
    ```javascript
    let add = function(a, b) {
      return a + b;
    }
    ```
3. **箭头函数**：简化写法，`this`指向父对象
    ```javascript
    let add = (a, b) => {
      return a + b;
    }
    ```

##### 对象与JSON
1. **对象定义**：键值对形式，属性访问使用`.`或`[]`
    ```javascript
    let stu = { name: '张三', age: 18, sex: '男' };
    console.log(stu.name);
    ```
2. **JSON序列化**：`JSON.stringify()`将对象转为JSON字符串
3. **JSON反序列化**：`JSON.parse()`将JSON字符串转为对象

### 3.DOM操作

1. **获取元素**
    - `document.querySelector('选择器')`：获取第一个匹配元素
    - `document.querySelectorAll('选择器')`：获取所有匹配元素，返回NodeList
2. **修改样式**：通过`style`属性修改元素CSS样式
    ```javascript
    let p = document.querySelector('p');
    p.style.color = 'red';
    ```
3. **遍历元素**：使用`for...of`循环遍历NodeList
    ```javascript
    let ps = document.querySelectorAll('p');
    for(let x of ps) {
      x.style.color = 'red';
    }
    ```

### 4.事件监听

1. **绑定方式**：`element.addEventListener('事件名', 回调函数)`
2. **常用事件**
    - `click`：鼠标点击
    - `mouseenter`：鼠标移入
    - `mouseleave`：鼠标移出
    - `focus`：获得焦点
    - `blur`：失去焦点
    - `keydown`：键盘按下
    - `keyup`：键盘抬起
    - `input`：表单输入
    - `submit`：表单提交
3. **事件对象**：回调函数接收`event`参数，包含事件相关信息
    - `event.target`：触发事件的元素
    - `event.currentTarget`：绑定事件的元素

### 5.JS模块化

1. **导出**：使用`export`关键字导出函数或变量
    ```javascript
    // util.js
    export function log(data) {
      console.log(data);
    }
    ```
2. **导入**：使用`import`关键字导入模块，需设置`type="module"`
    ```html
    <script src="./JS/05js模块化.js" type="module"></script>
    ```
    ```javascript
    import { log } from "./util.js";
    log("hello world");
    ```

### 6.Vue3基础

##### 引入方式
1. 通过CDN引入Vue3模块
    ```javascript
    import { createApp, ref } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'
    ```

##### 创建Vue实例
1. `createApp()`：创建Vue应用实例
2. `.mount('#容器')`：挂载到指定DOM元素

##### 核心概念

1. **data选项**：定义组件的数据，返回一个对象
    ```javascript
    data() {
      return {
        employees: [...]
      }
    }
    ```

2. **methods选项**：定义组件的方法
    ```javascript
    methods: {
      handleMouseEnter(event) {
        event.currentTarget.style.backgroundColor = 'rgb(196,212,225)';
      }
    }
    ```

3. **模板语法**
    - `{{表达式}}`：插值表达式，用于显示数据
    - `v-bind:属性`：动态绑定属性，简写为`:属性`
    - `v-on:事件`：绑定事件，简写为`@事件`
    - `v-for`：列表渲染，`v-for="(item, index) in list"`
    - `v-if/v-else-if/v-else`：条件渲染，根据条件决定是否加载元素

##### 事件绑定

1. 在模板中使用`v-on:事件名="方法名"`绑定事件
2. 方法接收`event`参数，可访问事件对象

##### 条件渲染
1. `v-if`：条件为false时，元素不会被渲染到DOM
2. `v-show`：条件为false时，元素通过`display:none`隐藏，仍存在于DOM中