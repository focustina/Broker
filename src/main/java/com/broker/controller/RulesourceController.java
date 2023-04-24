package com.broker.controller;


import com.broker.Client.MQTTSubsribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@RestController
@RequestMapping(value = "/rulesource",method = RequestMethod.POST)
public class RulesourceController {

    @Autowired
    private MQTTSubsribe mqttSubsribe;

    /**
     * 订阅主题
     * @param topic 主题
     * @param qos 消息级别
     * @return
     */
    @RequestMapping(value = "testSubsribe")
    public String testSubsribe(String topic, int qos) {
        mqttSubsribe.init(topic, qos);
        return "订阅'"+topic+"'成功";
    }

}

