# CmsCloud-KC
<h1 align="center">
  基于微服务的简单内容管理系统
</h1>

## 简介

 本仓库是一个基于**微服务简易的**内容管理系统 ,本人在工作之余开发,用于微服务等技术的学习 和 框架搭建能力的锻炼。目前内容不够完善，深度较浅，但会持续更新，并且会慢慢加深。


### 结构

**工程目录：**

* cms-commons：根据功能划分的公共模块工程，用来引入公共的依赖，工具类，以及自定义starter用于其他springboot工程引入使用。

* cms-business：服务工程集合，目前包含管理系统服务,
    * cms-center 移动端后台服务
    * cms-portal：移动端后台服务 
    * cms-file： 文件服务
* cms-gateway: 微服务网关
* cms-search： 搜索服务，使用ElasticSearch 
* cms-auth：授权中心 （没用上~~）




**项目基本结构：**
        ###### 基础结构都有如下

    ```
     - controller       ## 前端控制器
     - entity           ## 基础实体类
     - mapper           ## mapper 接口
        - xml           ## mapper.xml 文件
     - service          ## 处理业务逻辑
    ```    
    
### 技术描述

**技术栈：**
   *  微服务
        * SpringCloud  项目基于springcloud（后面考虑改成SpringCloudAlibaba）
        * nacos 注册中心 使用版本1.4.3 ,(2.0版本不行),使用**配置中心功能**进行文件虚拟路径的配置
        * Feign 服务间调用 (文件上传需要导入额外的依赖,cms-center里面有注释)
        * SpringSecurity 权限框架（cms-center）, **自定义无权限失败返回**，使用token进行权限的认证,**Redis进行token的续期**
        * redis 验证码、token续期、首页滚动页缓存
        * Mybatis （使用二级缓存），tkmybatis （使用此框架可以代替自己开发一些常用增删改查的业务代码）
   * 前端
        * element-ui  使用element-ui-template 作为管理系统的基础架构
        * uniapp 前端框架采用uniapp（此框架可打包H5和小程序）
        
**进度：**
   * 项目还未部署线上demo 正在积极部署~~
