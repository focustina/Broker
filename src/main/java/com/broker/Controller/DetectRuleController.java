package com.broker.Controller;




import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.broker.Detect.DetectionResult;
import com.broker.Detect.DetectionRule;
import com.broker.Entity.DetectRule;
import com.broker.Entity.RuleSource;
import com.broker.Mapper.DetectRuleMapper;
import com.broker.Mapper.RuleSourceMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
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

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.JSON.toJSON;


/**
 * 数据库插入数据
 */
@Slf4j
@RestController
@RequestMapping("/detectrule")
public class DetectRuleController {
    private MqttReceiveHandle mqttReceiveHandle;
    private RuleSource ruleSource;
    private DetectRule detectRule;
    private RuleSourceMapper sourceMapper;
    private DetectRuleMapper detectRuleMapper;
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
        if (ruledatasource == "ruleSource"){
            DetectionResult  detectionResult = JSONObject.parseObject(jsonMsg,DetectionResult.class);
            log.info("response:",detectionResult);
            String ruledectMsg = String.valueOf((detectionResult.getDetection_rule()));
            for(int i=0;i<ruledectMsg.length();i++){
                DetectionRule detectionRule =JSONObject.parseObject(ruledectMsg,DetectionRule.class);
                detectRule.setDetection_no(detectionResult.getDetection_no());
                detectRule.setDetection_tag(detectionResult.getDetection_tag());
                detectRule.setImage_id(detectionResult.getImage_id());
                detectRule.setPoint_id(detectionResult.getPoint_id());
                detectRule.setPoint_sub_id(detectionRule.getPoint_sub_id());
                detectRule.setDetection_item(detectionRule.getDetection_item());
                detectRule.setDetection_key(detectionRule.getDetection_key());
                detectRule.setDetection_value(detectionRule.getDetection_value());
                detectRuleMapper.insert(detectRule);

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
