[![Build Status](https://travis-ci.org/zhoutaoo/SpringCloud.svg?branch=master)](https://travis-ci.org/zhoutaoo/SpringCloud)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codecov](https://codecov.io/gh/zhoutaoo/SpringCloud/branch/master/graph/badge.svg)](https://codecov.io/gh/zhoutaoo/SpringCloud)

## 快速开始

### 先决条件

- [git](https://git-scm.com/)
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [maven](http://maven.apache.org/) 
- [postgresql](http://www.postgresql.org/)
- [redis](http://redis.io/download)
- [rabbitmq](http://rabbitmq.io/download)

### 开发环境

1. 克隆代码库： `git clone https://gitee.com/toopoo/SpringCloud.git`

2. 生成ide配置： `mvn idea:idea` 并导入对应的ide进行开发,IDE安装lombok插件

3. 初使化数据库： 执行服务目录下src/main/db下的ddl和dml脚本

### 编译 & 启动

启动服务： `mvn springboot:run` 

| 服务分类  | 服务名                     |   简介     |  应用地址                | 文档 |
|----------|---------------------------|-----------|-------------------------|------|
|  center  | eureka-server             | 注册中心   |  http://localhost:8761  |      |
|  center  | bus-server                | 消息中心   |  http://localhost:8071  |      |
|  center  | config-server             | 配置中心   |  http://localhost:8061  |      |
|  auth    | authorization-server      | 授权服务   |  http://localhost:8000  | [文档](./auth/authorization-server)     |
|  auth    | authentication-server     | 签权服务   |  http://localhost:8001  |      |
|  auth    | authentication-client     | 签权客户端  |  jar包引入               |      |
|  gateway | gateway                   | 网关       |  http://localhost:8443  |      |
|  monitor | admin                     | 总体监控    |  http://localhost:8022  |      |
|  monitor | hystrix-dashboard         | 性能指标展示|  http://localhost:8021  |      |
|  monitor | turbine                   | 性能指标收集|  http://localhost:8031  |      |
|  monitor | zipkin                    | 日志收集   |  http://localhost:8091  |      |


### 测试

运行 `mvn test` 启动测试.



## 开发指南

### 项目目录结构

```
├── auth                           --授权认证子项目
│   ├── authentication-server        --认证组件服务端 
│   ├── authentication-client        --认证组件客户端 
│   ├── authorization-server         --授权组件服务端
│   ├── db                           --子项目公共数据库脚本
│   └── pom.xml                      --子项目maven配置文件
├── center               --中心子项目
│   ├── bus                --消息中心
│   ├── config             --配置中心
│   ├── eureka             --注册中心 
│   └── pom.xml
├── common               --通用子项目
│   ├── core               --核心类库
│   ├── test               --测试工具类库
│   ├── web                --WEB核心类库
│   └── pom.xml          
├── data                 --server及服务数据存储目录
│   ├── logs               --日志存储位置
│   ├── postgres           --postgres数据库文件存储目录 
│   ├── rabbitmq           --rabbitmq数据文件存储目录
│   └── redis              --redis数据文件存储目录
├── gateway              --网关子项目  
│   ├── gateway-web        --基于springcloud gateway的网关
│   ├── gateway-zuul       --基于netflix zuul的网关
│   └── pom.xml
├── monitor              --监控、日志及服务管理子项目
│   ├── admin              --springcloud admin管理
│   ├── hystrix-dashboard  --hystrix监控
│   ├── turbine            --turbine监控聚集 
│   ├── zipkin             --日志汇总
│   └── pom.xml
├── services             --业务服务子项目
│   ├── consumer-feign     --消费者服务 feign demo
│   ├── consumer-ribbon    --消费者服务 ribbon demo 
│   ├── producer           --服务提供者，产品服务
│   └── pom.xml
├── readme.md            --readme文档入口
├── docker-compose.yml   --docker compose配置文件 
└── pom.xml              --业务服务子项目
```

### module目录结构

```
├── logs                     --日志目录
│   ├── spring.log
│   └── spring.log.2018-04-15.0.gz
├── pom.xml                  --module maven配置文件
├── src                      --源码目录
│   ├── main                   --源文件
│   │   ├── db                 --服务db脚本目录
│   │   │   ├── ddl              --建表语句等ddl
│   │   │   └── dml              --基础数据dml
│   │   ├── docker             --docker相关配置文件
│   │   │   └── Dockerfile       --dockerfile
│   │   ├── docs               --接口文档目录，一般由swagger生成
│   │   ├── java               --java源码目录
│   │   │   ├── dao              --数据操作层
│   │   │   ├── service          --业务逻辑层
│   │   │   ├── provider         --调用第三方服务的提供类
│   │   │   ├── rest             --接口controller
│   │   │   ├── entity           --实体类
│   │   │   │   ├── form           --rest表单校验
│   │   │   │   ├── param          --dao参数，可以由form转化来
│   │   │   │   ├── po             --实体类
│   │   │   │   └── vo             --rest返回对象
│   │   │   ├── events           --事件或消息处理类
│   │   │   ├── config           --配置类
│   │   │   ├── exception        --异常处理相关类
│   │   │   ├── interceptor      --拦截器相关类
│   │   │   └── task             --定时任务
│   │   └── resources          --配置文件目录 
│   │       ├── application.yml  --springboot的应用配置文件
│   │       └── bootstrap.yml    --springboot的配置文件
│   └── test                   --测试目录
│       ├── java                 --java测试案例目录
│       └── resources          --配置文件目录 
│          └── application.yml   --springboot test的配置文件
└── target                     --编译目标目录
```

## 数据库设计规范

### 表设计规范

1、表名全部小写，单词间通过'_'间隔

2、主键命名为'id'，类型为serial自增长主键，会默认创建名为[表名_id_seq]的序列

3、必须包含4个审计字段且不能为空。created_time、updated_time、created_by、updated_by。

4、关键词要求大写，使用IDE如idea进行格式化

5、常量枚举全部用大写

### 外键及索引命名规范

1、唯一索引：ux_表名_索引字段。如：ux_resource_code

2、普通索引：ix_表名_索引字段。如：ix_role_name

3、外键命名：fk_表名_字段名。如：fk_orders_product_id


### 字段长度规则

| 名称类  | 类型    | 长度  |  备注  |
|--------|---------|------|--------|
| 编码类  | varchar |  100 |        |
| 账号类  | varchar |  100 | 如email，username |
| 状态类  | varchar |  5   | 如订单状态等       |
| 名称类  | varchar |  200 | 中文名称，如产品名  |
| 手机电话| varchar |  20  |        |
| 描述简介| varchar |  500 |        |
| 网址类  | varchar |  500 | 如url  |
| 时间类  | timestamp |    |        |
    

## URL和方法命名规范

### RESTFUL URL命名规范

API URI design
API URI 设计最重要的一个原则： nouns (not verbs!) ，名词（而不是动词）。

CRUD 简单 URI：

|  方法   | URL       |       功能       |
|--------|-----------|------------------|
| GET    | /users    | 获取用户列表       |
| GET    | /users/1  | 获取 id 为 1 的用户|
| POST   | /users    | 创建一个用户       |
| PUT    | /users/1  | 替换 id 为 1 的用户|
| PATCH  | /users/1  | 修改 id 为 1 的用户|
| DELETE | /users/1  | 删除 id 为 1 的用户|

上面是对某一种资源进行操作的 URI，那如果是有关联的资源，或者称为级联的资源，该如何设计 URI 呢？比如某一用户下的产品：

|  方法   | URL                 |             功能                   |
|--------|---------------------|------------------------------------|
| GET    | /users/1/products   | 获取 Id 为 1 用户下的产品列表         |
| GET    | /users/1/products/2 | 获取 Id 为 1 用户下 Id 为 2 的产品    |
| POST   | /users/1/products   | 在 Id 为 1 用户下，创建一个产品       |
| PUT    | /users/1/products/2 | 在 Id 为 1 用户下，替换 Id 为 2 的产品|
| PATCH  | /users/1/products/2 | 修改 Id 为 1 的用户下 Id 为 2 的产品  |
| DELETE | /users/1/products/2 | 删除 Id 为 1 的用户下 Id 为 2 的产品  |

### 方法命名规范

### Mapper

insert/add
delete
update
query
search

### Service

add
get
delete
update
save
query
search

### Rest

add
get
delete
update
save
query
search
