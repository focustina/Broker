package com.broker;

import com.broker.Client.MQTTServer;
import com.broker.Client.MQTTSubsribe;
import com.broker.pojo.Ruleaggregation;
import com.broker.pojo.Rulehandle;
import com.broker.service.RulehandleService;
import com.broker.service.RulesourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BrokerApplicationTests {

    @Autowired
    private MQTTServer mqttServer;

    @Autowired
    private MQTTSubsribe    mqttSubsribe;
    private RulesourceService rulesourceService;
    @Autowired
    private RulehandleService rulehandleService;
    @Test
    void contextLoads() {

    }

//    @Test
//    void testRulehandleService() {
////        mqttServer.sendMQTTMessage("test.topic", "{\"name\":\"Hello World\"}" ,0);
////        Rulehandle rulehandle = new Rulehandle();
////        rulehandle.setId("38748347289");
////        rulehandle.setWarn(1L);
////        rulehandle.setAreaId("3432423");
////        rulehandle.setDetectionNo(394893394L);
////        rulehandle.setDetectionTag("34874583445");
////        rulehandle.setImageCollect("[9343943,123231]");
////        rulehandle.setPointCollect("[1,3]");
////        rulehandle.setScenesId("ewrwerw");
////        rulehandle.setSceneVersion("3");
////        rulehandle.setEventTime(123343343l);
////        boolean flage = rulehandleService.save(rulehandle);
////        System.out.println(flage);
//
//
//    }

    @Test
    public void testMQTTSubsribe() {
//        mqttServer.sendMQTTMessage("test.topic", "{\"name\":\"Hello World\"}" ,0);
        mqttSubsribe.init("edgex/rule/device/onvif-camera/ruleRecord/1649972252437880833", 0);
        mqttSubsribe.subscribe("edgex/rule/device/onvif-camera/ruleRecord/1649972252437880833",0);

    }
}
