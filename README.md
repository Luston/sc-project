# sc-project
1.运行本项目之前，请先安装rabbitMq;

2.对于zipkin的配置，包里不含zipkinServer,基于springboot2.0之后，官方已不推荐自己定义zipkinServer,请自行下载zipkinServer 的jar,并运行。
当配置了消息中间件时（如rabbitMq）,并且若进行数据库持久化保存，则在运行时需额外配置消息中间件信息以及数据库信息，具体命令如下：
java -jar zipkin-server-2.9.4-exec.jar--zipkin.collector.rabbitmq.addresses=localhost --STORAGE_TYPE=mysql（数据库类型） --MYSQL_HOST=localhost --MYSQL_TCP_PORT=3306 --MYSQL_DB=sc_project（数据库名） --MYSQL_USER=root --MYSQL_PASS=root
