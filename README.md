# rpc-demo
rpc demo built upon dubbo

## rpc相关问题
### 信息流程
![image](https://dubbo.incubator.apache.org/docs/zh-cn/user/sources/images/dubbo-architecture.jpg)

### 传输协议
> The framework supports multiple protocols, including dubbo, RMI, hessian, HTTP, web service, thrift, memcached and redis.
* Dubbo允许配置多协议，在不同服务上支持不同协议或者同一服务上同时支持多种协议.
* dubbo
    - keeps a persistent connection between providers and consumers
    - suitable for transmitting small-scale data packets (<100K)
    - configurable properties: `port`, `conn-per-consumer`, `max-conn`, `serialization implementations`, `result caching(on the consumer side)`
* http


### 集群部署
* zk管理服务注册
* 不同主机上的服务注册到zk上时, 注意填写主机对应的ip(默认配置成网关ip), 保证服务可达
* 负载均衡
    - random [default]: 随机, 按权重设置随机概率.
    - round-robin: 轮询, 按公约后的权重设置轮询比率.
    - least-active: 最少活跃调用数, 相同活跃数的随机, 活跃数指调用前后计数差。
    - consistent-hash: 一致性Hash, 相同参数的请求总是发到同一提供者.
* 容错策略(fault tolerance)
    - fail-over [default]: 失败自动切换, 当出现失败, 重试其它服务器; 通常用于读操作，可通过 retries="2" 来设置重试次数(不含第一次)。
    - fail-safe: 失败安全, 出现异常时，直接忽略。通常用于写入审计日志等操作。
    - fail-fast: 快速失败, 只发起一次调用, 失败立即报错.
    - fail-back: 失败自动恢复, 后台记录失败请求, 定时重发; 通常用于消息通知操作。
    - forking: 并行调用多个服务器，只要一个成功即返回; 通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
    - broadcast(since `2.1.0`): 广播调用所有提供者, 逐个调用, 任意一台报错则报错; 常用于通知所有提供者更新缓存或日志等本地资源信息。
* 容量规划
    - 使用12台网站标配机器提供服务(8核CPU, 8G内存), 每天接收 4 亿次远程调用
    - 平均负载在 1 以下, 平均响应时间 2.3 到 2.5 毫秒


### zookeeper(注册中心)的角色/功能

### dubbo的角色/功能

### 最佳实践
* https://dubbo.incubator.apache.org/zh-cn/docs/user/best-practice.html
* https://dubbo.incubator.apache.org/zh-cn/docs/user/recommend.html

### 性能测试
* 服务端
* 客户端

### 系统监控

### rpc vs http接口
* rpc是s/s模式, http接口是c/s模式
* rpc通过公共jar共享, http接口通过接口文档共享
