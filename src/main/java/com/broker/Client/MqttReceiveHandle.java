package com.broker.Client;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.sun.tools.jdi.Packet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Slf4j
@Component
public class MqttReceiveHandle {
    Gson gson = new Gson();

    public void handle(Message<?> message) {
        log.info("收到订阅消息: {}",gson.toJson(message));
        String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
        log.info("消息主题：{}", topic);
        String jsonMsg = String.valueOf((message.getPayload()));

        //log.info("发送的Packet数据{}", JSON.toJSONString(packet));

    }
}