# rpc-demo
rpc demo built upon dubbo

## rpc相关问题
### 信息流程
![image](https://dubbo.incubator.apache.org/docs/zh-cn/user/sources/images/dubbo-architecture.jpg)

### 传输协议
> The framework supports multiple protocols, including dubbo, RMI, hessian, HTTP, web service, thrift, memcached and redis.
* dubbo
    - keeps a persistent connection between providers and consumers
    - suitable for transmitting small-scale data packets (<100K)
    - configurable properties: `port`, `conn-per-consumer`, `max-conn`, `serialization implementations`, `result caching(on the consumer side)`

### 集群部署
* zk管理服务注册
* 不同主机上的服务注册到zk上时, 注意填写主机对应的ip(默认配置成网关ip), 保证服务可达

### 负载均衡
> Currently, the framework supports a few load-balancing strategies, 
which can be configured both on provider's side (in `dubbo:service`) and on consumer's side (in `dubbo:reference`)!
* random
* round-robin
* least-active
* consistent-hash.

### 容错策略(fault tolerance)
> Several fault tolerance strategies are supported in Dubbo. The strategy is configured on provider's side(in `dubbo:service)
* fail-over: when one provider fails, the consumer can try with some other service providers in the cluster
* fail-safe
* fail-fast
* fail-back
* forking

### zookeeper(注册中心)的角色/功能

### dubbo的角色/功能

### 性能测试
* 服务端
* 客户端

### 系统监控

### rpc vs http接口
* rpc是s/s模式, http接口是c/s模式
* rpc通过公共jar共享, http接口通过接口文档共享
