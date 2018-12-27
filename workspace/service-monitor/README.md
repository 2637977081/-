# Service Monitor
微服务监控系统

##idea运行VM参数设置
```
-Xms256m -Xmx256m
-Dspring.application.name={个人姓名拼音}-service-monitor
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
univer_port=9091
```