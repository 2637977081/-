# Service Account
用户管理

##idea运行VM参数设置
```
-Xms256m -Xmx256m
-Dspring.application.name={个人姓名拼音}-service-account
```

## 打包
```
mvn clean package
```

## 系统变量
```properties
#微服务主机地址
univer_host=localhost
#微服务端口号
univer_port=9031
#GRPC端口号
univer_grpc_port=9032
#数据库URL
univer_datasource_url=jdbc:mysql://univer-mysql.home.univer:3306/account_dev?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true
#数据库用户名
univer_datasource_name=root
#数据库用户密码
univer_datasource_password=univer
#Redis数据库索引
univer_redis_database=10
#Redis地址
univer_redis_host=univer-redis.home.univer
#Redis端口号
univer_redis_port=6379
```