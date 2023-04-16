package com.broker.Controller;




import com.broker.Detect.DetectionResult;
import com.broker.Detect.DetectionRule;
import com.broker.Entity.DetectRule;
import com.broker.Mapper.DetectRuleMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.broker.Client.MqttReceiveHandle;
import com.alibaba.fastjson.JSONObject;

import java.util.List;


/**
 * 数据库插入数据
 */
@Slf4j
@RestController
@RequestMapping("/detectrule")
public class DetectRuleController {
    private MqttReceiveHandle mqttReceiveHandle;
    Gson gson = new Gson();

    @Autowired
    DetectRuleMapper mapper;
    public void handle(Message<?> message){
        log.info("收到订阅消息: {}",gson.toJson(message));
        String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
        String[] topicArr = topic.split("/");
        String ruletopic  = topicArr[0];
        String ruledatasource = topicArr[4];
        log.info("消息主题：{}", topic);
        String jsonMsg = String.valueOf((message.getPayload()));
        DetectionResult  detectionResult = JSONObject.parseObject(jsonMsg,DetectionResult.class);

        if (ruledatasource == "ruleSource"){
            log.info("response:",detectionResult);
            List detectrule_array = detectionResult.getDetection_rule();
            for(int i=0;i<detectrule_array.size();i++){
                DetectRule detectRule = (DetectRule) detectrule_array.get(i);
                log.warn("detectRule {}",detectRule);
                mapper.insert(detectRule);

            }




        }

    }
//    @PostMapping
//    public Boolean saveDetectRule(@RequestBody DetectRule detectRule){
//
//        log.warn("detectRule {}",detectRule);
//        int i = mapper.insert(detectRule);
//        return i == 1;
//    }
}
