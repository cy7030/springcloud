package com.yong.sericefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient//向服务中心注册
@EnableFeignClients//开启Feign功能
@EnableHystrixDashboard//开启hystrix 仪表盘功能
@EnableCircuitBreaker  //启动端容器  此注解在打开仪表盘的时候必须有， 没有的话会报Unable to connect to Command Metric Stream.无法连接错误
public class SericeFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SericeFeignApplication.class, args);
    }
}
