# sc-project
1.运行本项目之前，请先安装rabbitMq;

2.对于zipkin的配置，包里不含zipkinServer,基于springboot2.0之后，官方已不推荐自己定义zipkinServer,请自行下载zipkinServer 的jar,并运行。
当配置了消息中间件时（如rabbitMq）,运行时需额外配置消息中间件信息，具体命令如下：
java -jar zipkin-server-2.10.1-exec.jar --zipkin.collector.rabbitmq.addresses=localhost
