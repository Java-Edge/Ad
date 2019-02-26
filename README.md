# 0 联系我
![](http://upload-images.jianshu.io/upload_images/4685968-6a8b28d2fd95e8b7?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240 "图片标题") 
1.[Java开发技术交流Q群](https://jq.qq.com/?_wv=1027&k=5UB4P1T)

2.[完整博客链接](http://www.shishusheng.com)

3.[个人知乎](http://www.zhihu.com/people/shi-shu-sheng-)

4.[gayhub](https://github.com/Wasabi1234)

# SpringCloud＋Kafka＋MySQL实现微服务架构下的广告系统

# 环境参数
JDK 1.8 
SpringCloud: Finchley.RELEASE 
Kafka 2.0 
Maven 3.5.0 
MySQL 5.7 
IDE IntelliJ IDEA: 2019.1

# 1 博客教程
## 1.1 [简介](https://blog.csdn.net/qq_33589510/article/details/87914143)
广告系统的介绍、所使用的技术介绍、学习规划,广告系统的思想、广告系统的技术实现架构、准备工作和广告系统的代码目录结构等

## 1.2 [基础框架搭建](https://blog.csdn.net/qq_33589510/article/details/87914529)
完成项目骨架的开发，包括搭建注册中心和服务网关

## 1.3 [常规模块的设计与实现](https://blog.csdn.net/qq_33589510/article/details/87917296)
实现广告系统微服务通用的功能，例如：统一响应格式、全局异常处理、通用代码定义、通用配置定义等

## 1.4 [广告投放系统的开发]
实现投放系统，投放系统即实现对广告数据的存储.
会对表结构设计进行介绍，使用 JPA 实现对各个数据表的增删改查。同时，由于会涉及Spring相关的知识点（Spring IOC、Spring MVC、SpringBoot），也会对这些做基础介绍

## 1.5  [广告检索系统 - 微服务调用]
介绍使用 Ribbon 与 Feign 组件实现微服务之间的调用

## 1.6 [广告检索系统 - 广告数据索引的设计与实现]
广告检索系统的核心是实现广告检索服务，为加快广告检索的速度，良好的索引设计是不可缺少的。本章首先对索引的设计与维护进行介绍，之后，实现广告数据的索引服务。

## 1.7 [广告检索系统 - 加载全量索引]()
广告数据导出的实现，之后各层级索引操作的实现，最后完成全量索引的加载操作

## 1.8 [广告检索系统-监听Binlog构造增量数据](https://blog.csdn.net/qq_33589510/article/details/87881882)
介绍MySQL Binlog，哪些作用和特性；怎样实现监听Binlog构造增量数据

![](https://upload-images.jianshu.io/upload_images/4685968-091b54b1fa8b5748.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
