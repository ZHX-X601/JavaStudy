# 计划
网络编程，反射与动态代理
# 总结
### 1.网络编程
##### 1.InetAddress
1. 表示IP地址对象
2. 获取方式
    - `InetAddress.getByName("IP地址或主机名")`：既可以传IP也可以传主机名
    - `InetAddress.getLocalHost()`：获取本地主机
3. 常用方法
    - `getHostAddress()`：获取IP地址字符串
    - `getHostName()`：获取主机名，会尝试反向DNS解析，如果失败返回IP字符串本身
    - `getCanonicalHostName()`：获取完全限定域名（FQDN），进行更彻底的反向解析
4. 注意事项
    - 通过IP获取InetAddress时，`getHostName()`可能返回IP（反向解析失败）
    - `getByName()`支持IPv4和IPv6地址
    - 如果参数是合法IP格式，不会发起DNS查询，直接构造对象

##### 2.UDP通信
1. 特点：无连接、不可靠、速度快
2. 使用 `DatagramSocket` 和 `DatagramPacket`
3. 发送端
    - 创建 `DatagramSocket`
    - 封装 `DatagramPacket`（数据、目标IP、端口）
    - 调用 `send()` 发送
4. 接收端
    - 创建 `DatagramSocket`（绑定端口）
    - 创建空的 `DatagramPacket` 用于接收
    - 调用 `receive()` 接收（阻塞式）
    - 通过 `getData()`、`getLength()` 获取数据
5. 组播：使用多播地址 `224.0.0.1`，接收端需调用 `joinGroup()` 加入组播

##### 3.TCP通信
1. 特点：面向连接、可靠、速度较慢
2. 三次握手建立连接，四次挥手断开连接
3. 服务器端
    - 创建 `ServerSocket`（绑定端口）
    - 调用 `accept()` 等待客户端连接（阻塞式）
    - 获取 `Socket` 对象进行通信
4. 客户端
    - 创建 `Socket`（指定服务器IP和端口）
    - 连接成功后获取流进行通信
5. 多次发送与反馈
    - 客户端循环发送数据，服务器循环接收
    - 添加反馈机制：服务器收到数据后返回确认信息
    - 使用 `exit` 关键字退出循环
6. 关键问题与注意事项
    - **消息边界**：TCP是流式传输，必须定义应用层协议（如换行符分隔），否则消息会粘连
    - **readLine()阻塞**：是阻塞方法，没数据会一直等，直到收到换行符、连接关闭或超时
    - **read()返回值处理**：返回`int`，流结束返回-1，强制转换为`char`会导致无法检测流结束（-1转为`'\uffff'`）
    - **flush()**：发送数据后需调用确保数据立即发出，避免缓冲延迟
    - **socket.shutdownOutput()**：关闭输出流但保持连接，接收端会读到EOF；`socket.close()`完全关闭连接
    - **setSoTimeout()**：设置读取超时，防止永久阻塞

##### 4.TCP文件传输
1. 客户端
    - 使用 `FileInputStream` 读取文件
    - 通过 `BufferedInputStream` 提高效率
    - 写入 `OutputStream` 发送到服务器
    - 发送完毕后调用 `socket.shutdownOutput()` 关闭输出流（告知服务器发送结束）
    - 读取服务器反馈信息
2. 服务器端
    - 使用 `BufferedInputStream` 接收数据
    - 生成UUID作为文件名避免重复
    - 使用 `BufferedOutputStream` 写入文件
    - 发送反馈信息给客户端

##### 5.多线程服务器
1. 使用线程池处理多个客户端连接
2. 创建 `receiveFileTask` 实现 `Runnable` 接口
3. 将每个客户端的 `Socket` 封装为任务提交到线程池
4. 服务器主循环持续接收新连接
5. 关闭服务器时先关闭线程池再关闭 `ServerSocket`

### 2.反射
##### 1.Class对象获取方式
1. `Class.forName("全类名")`：最常用，解耦
2. `类名.class`：编译期确定
3. `对象.getClass()`：运行时获取
4. 同一个类的多个Class对象是同一个（类加载器只加载一次）

##### 2.反射操作构造方法
1. `clazz.newInstance()`：调用无参构造创建对象
2. `clazz.getConstructor(参数类型...)`：获取public有参构造
3. `constructor.newInstance(参数值...)`：调用构造创建对象

##### 3.反射操作字段
1. `clazz.getField("字段名")`：只能获取public字段（包括父类继承的）
2. `clazz.getDeclaredField("字段名")`：获取本类中所有访问级别的字段（包括private），不包括父类字段
3. `field.setAccessible(true)`：取消访问检查，必须在获取字段后调用
4. `field.get(对象)`：获取字段值
5. `field.set(对象, 值)`：设置字段值

##### 4.反射操作方法
1. `clazz.getMethod("方法名", 参数类型...)`：获取public方法
2. `method.invoke(对象, 参数值...)`：调用方法并返回结果
3. 可操作私有方法（需先调用 `setAccessible(true)`）

### 3.动态代理
##### 1.概念
1. 代理模式：通过代理对象访问真实对象，增强功能
2. 动态代理：在运行时动态生成代理类

##### 2.实现方式
1. 创建接口定义需要代理的方法
2. 创建真实对象实现接口
3. 使用 `Proxy.newProxyInstance()` 生成代理对象
4. 参数
    - `ClassLoader`：类加载器
    - `Class[] interfaces`：代理类实现的接口
    - `InvocationHandler`：调用处理器

##### 3.InvocationHandler
1. 实现 `invoke(Object proxy, Method method, Object[] args)` 方法
2. `proxy`：代理对象
3. `method`：被调用的方法
4. `args`：方法参数
5. 在方法调用前后添加增强逻辑
6. 调用 `method.invoke(真实对象, args)` 执行真实方法

##### 4.代理类的本质（底层机制）
1. 代理类是JVM在运行时动态生成的，类名格式为 `com.sun.proxy.$Proxy0`
2. 继承 `java.lang.reflect.Proxy`，实现指定的接口（如`Star`）
3. 类修饰符为 `public final`，不能被继承
4. 只有一个构造方法，接收 `InvocationHandler` 参数
5. 所有方法体内只有一行逻辑：转发给 `InvocationHandler.invoke()`

##### 5.JDK动态代理必须基于接口的原因
1. Java是单继承语言，代理类必须继承 `Proxy`
2. 因此无法再继承其他业务父类，只能通过实现接口来定义行为

##### 6.代理对象与真实对象的区别
| 对比项  | 真实对象（如`BigStar`）            | 代理对象（如`$Proxy0`）             |
| ---- | --------------------------- | ---------------------------- |
| 继承关系 | 直接实现接口                      | 继承`Proxy`并实现接口               |
| 方法逻辑 | 包含具体业务代码                    | 全部转发给`InvocationHandler`     |
| 类型检查 | `instanceof BigStar`为`true` | `instanceof BigStar`为`false` |
| 本质   | 真正的业务对象                     | 业务对象的"替身"或"门卫"               |

##### 7.应用场景
1. **日志记录**：记录方法调用信息
2. **性能监控**：统计方法执行耗时
3. **事务管理**：数据库操作前后开启/提交/回滚事务
4. **权限控制**：检查用户是否有权执行方法
5. **缓存控制**：第一次查询存缓存，后续直接取缓存
6. **异常封装**：将具体异常统一转为业务异常
7. **远程调用（RPC）**：本地调用方法，实际通过网络发给远程服务器执行
8. **AOP（面向切面编程）**：解耦业务逻辑与通用增强逻辑