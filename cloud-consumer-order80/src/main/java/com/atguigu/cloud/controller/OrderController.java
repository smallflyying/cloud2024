package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/14
 */
@RestController
public class OrderController {

    //public static final String PaymentSrv_URL = "http://localhost:8001"; // 先写死，硬编译
    public static final String PaymentSrv_URL = "http://cloud-payment-service"; //服务注册中心上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     * @param payDTO
     * @return
     */
    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    // 删除+修改操作作为家庭作业，O(∩_∩)O。。。。。。。
    // 查询订单流水
    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ResultData.class, id);
    }

    // 查询所有订单流水
    @GetMapping(value = "/consumer/pay/getAll")
    public ResultData getAllPayInfo() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getAll", ResultData.class);
    }

    // 删除 方式一无返回值
    @DeleteMapping(value = "/consumer/pay/del/{id}")
    public void deletePayInfo(@PathVariable("id") Integer id) {
        restTemplate.delete(PaymentSrv_URL + "/pay/del/"+id, ResultData.class, id);
    }

    // 删除 方式二有返回值
    @DeleteMapping(value = "/consumer/pay/del2/{id}")
    public ResultData deletePayInfo2(@PathVariable("id") Integer id) {
        return restTemplate.exchange(PaymentSrv_URL + "/pay/del/"+id, HttpMethod.DELETE, null,ResultData.class, id).getBody();
    }

    // 修改 方式一：无返回值
    @PutMapping(value = "/consumer/pay/update")
    public void updatePayInfo(@RequestBody PayDTO payDTO) {
        restTemplate.put(PaymentSrv_URL + "/pay/update", payDTO, ResultData.class);
    }

    // 修改 方式二：有返回值
    @PutMapping(value = "/consumer/pay/update2")
    public ResultData updatePayInfo2(@RequestBody PayDTO payDTO) {
        return restTemplate.exchange(PaymentSrv_URL + "/pay/update", HttpMethod.PUT, new HttpEntity<>(payDTO),ResultData.class, payDTO).getBody();
    }

    @GetMapping(value = "/consumer/pay/get/info")
    public String getInfoByConsul() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }
}
