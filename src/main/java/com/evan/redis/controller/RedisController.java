package com.evan.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
/**
 * @author evanYang
 * @version 1.0
 * @date 27/04/2020 11:12
 */
@Controller
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        System.out.println("测试reis sentinel "+ LocalDateTime.now());
        int value= (int)(Math.random()*100);
        String v2="v"+value;
        redisTemplate.opsForValue().set(v2,v2);
        String name = redisTemplate.opsForValue().get(v2);
        return name;
    }
}
