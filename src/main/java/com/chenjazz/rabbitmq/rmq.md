
# 启动

```
systemctl start rabbitmq-server.service
systemctl restart rabbitmq-server.service
```
# 地址
管理页面
```
http://127.0.0.1:15672/

guest guest
```
管理api
```
http://192.168.0.98:15672/api/
```

# 命令

# 概念
Connection 相当于一个TCP连接

Channel  相当于构建与TCP之上虚拟连接（唯一ID）---多个信道可以共享一个TCP连接，免去了创建销毁TCP连接的代价

Queue  构建与Channel之上，用来存取消息 
       
      
Exchange 生产者将消息发送到Exchange（交换器，下图中的X），由Exchange将消息路由到一个或多个Queue中（或者丢弃）

Binding
    RabbitMQ中通过Binding将Exchange与Queue关联起来，这样RabbitMQ就知道如何正确地将消息路由到指定的Queue了。
    
routing key    将消息发送到 Exchange 时指定

binding key    创建 Queue 时候指定


Exchange Types 将消息发送到 Exchange 时指定
   fanout：它会把所有发送到该Exchange的消息路由到所有与它绑定的Queue中
   direct 它会把消息路由到那些binding key与routing key完全匹配的Queue中
   topic  我们将被句点号“. ”分隔开的每一段独立的字符串称为一个单词。用于做模糊匹配，其中“*”用于匹配一个单词，“#”用于匹配多个单词
   headers  略。
