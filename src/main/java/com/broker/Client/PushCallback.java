package com.broker.Client;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.broker.pojo.Detectrule;
import com.broker.pojo.Rulehandle;
import com.broker.pojo.Rulesource;
import com.broker.service.DetectruleService;
import com.broker.service.RulehandleService;
import com.broker.service.RulesourceService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 主要用来接收和处理订阅主题的消息
 */
public class PushCallback implements MqttCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(PushCallback.class);
 
    private MQTTServer mqttServer;

    private MQTTSubsribe mqttSubsribe;
 
    public PushCallback(MQTTServer mqttServer) {
        this.mqttServer = mqttServer;
    }

    public PushCallback(MQTTSubsribe mqttSubsribe) {
        this.mqttSubsribe = mqttSubsribe;
    }


    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        LOGGER.info("---------------------连接断开，可以做重连");
        mqttServer.subsribeConnect();
 
        while (true){
            try {
                //如果没有发生异常说明连接成功，如果发生异常，则死循环
                Thread.sleep(1000);
                break;
            }catch (Exception e){
                continue;
            }
        }
 
    }
 
    /**
     * 发送消息，消息到达后处理方法
     * @param token
     */
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------" + token.isComplete());
    }
 
    /**
     * 接收所订阅的主题的消息并处理
     * @param topic
     * @param message
     */
    public void messageArrived(String topic, MqttMessage message) throws Exception {
//        // subscribe后得到的消息会执行到这里面
//        String[] topicArr = topic.split("/");
//        String datasource = topicArr[4];
//        if(message.getPayload()!=null){
//            if(datasource=="ruleSource"){
//                 RulehandleService rulehandleService;
//
//            }
//        }
        int count = 0;
        while (true){
            String result = new String(message.getPayload(),"UTF-8");
            System.out.println("接收消息主题 : " + topic);
            System.out.println("接收消息Qos : " + message.getQos());
            System.out.println("接收消息内容 : " + result);
            count = count +1;

        }



//        if(topic.contains("ruleSource")) {
//
//            RulesourceService service = SpringUtil.getBean("ruleSourceService");
//            service.saveResult(result);
//
//        } else if (topic.equals("ruleRecord")) {
//            RulehandleService service = SpringUtil.getBean("ruleRecordService");
//            // 持久化2
//        } else {
//            //无效的消息
//        }

        //这里可以针对收到的消息做处理，比如持久化
    }
 
}