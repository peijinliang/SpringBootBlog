# SpringBootBlog
Create a personal blogging system for Springboot。

本项目是依赖于SpringBoot搭建的个人博客系统。

技术栈比较简单：
1.SpringBoot 
2.前端BootStrap
3.Markdown编辑器
4.SpringSecurity权限校验
5.Mongodb文件服务器支持
6.分布式搜索引擎ElasticSearch

H2数据库是内存数据库
配置：
# 使用 H2 控制台
# spring.h2.console.enabled=true
访问:localhost:8080/h2-console 可以进入H2操作界面


数据结构：
指具有固定格式或有限长度的数据，如数据库，元数据。


非结构化数据：
redis、 mongdb 、ElasticSearch

搜索方式：
顺序扫描法 Serical Scanning;
全文搜索 full text Search;

全文搜索实现原理：
建立文库
建立索引
执行搜索
过滤结果(过滤用户搜索)

通过把非结构化数据创建索引的方式变成结构化数据，来实现全文搜索的功能。

Java全文搜索引擎
lucene: 露西   发动机  但是普通用户又不会开

ElasticSearch  宝马       
Solr  大众   

1、都有分布式的功能
2、Solr 支持的数据格式比较多
3、ElasticSearch 只有json 实时搜索高于Solr
4、传统企业  用的是Solr

ElasticSearch
1、高度可扩展的开源全文搜索引擎和分析引擎
2、快速地、近实时地对大数据进行存储、搜索和分析
3、支持具有复杂的数据搜索需求的企业级应用

特点：分布式、高可用 、多类型、多API 、面向文档 、异步写入、近实时。
核心概念：
近实时  写入缓存  写入硬盘 中间间隔1s
集群     
节点  集群中单个服务器，参与集群的搜索，节点是集群分配的。
索引  每一个索引都有一个名称
类型  
文档 
分片  一个索引当成多个分片 并且建立多个副本  增加吞吐量
副本  故障是不可避免 将副本分片 



基于lucene 、Apache开源产品
将数据进行分片。



async 是否进行异步请求页面
1.第一次是同步请求界面(数据量比较多)
2.第二次是异步请求，数据量小很多




    

