//package com.broker.Client;
//
//import lombok.extern.slf4j.Slf4j;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.annotation.IntegrationComponentScan;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.core.MessageProducer;
//import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
//import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
//import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
//import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
//import org.springframework.messaging.MessagingException;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * mqtt 推送and接收 消息类
// **/
//@Configuration
//@IntegrationComponentScan
//@Slf4j
//public class MqttSenderAndReceiveConfig {
//
//    private static final byte[] WILL_DATA;
//
//    static {
//        WILL_DATA = "offline".getBytes();
//    }
//
//    @Autowired
//    private MqttReceiveHandle mqttReceiveHandle;
//
//    private String username = "admin";
//
//    private String password = "public";
//
//
//    private String hostUrl = "tcp://192.168.100.213:1883";
//
//    private String clientId = "serve";
//
//    private String defaultTopic ="edgex/rule/device/onvif-camera/ruleSource/9e34aebb-0446-4d13-a91f-2ff2871d504b";
//
//    private int completionTimeout;   //连接超时
//
//    /**
//     * MQTT连接器选项
//     **/
//    @Bean(value = "getMqttConnectOptions")
//    public MqttConnectOptions getMqttConnectOptions1() {
//        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
//        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
//        mqttConnectOptions.setCleanSession(true);
//        // 设置超时时间 单位为秒
//        mqttConnectOptions.setConnectionTimeout(10);
//        mqttConnectOptions.setAutomaticReconnect(true);
//        mqttConnectOptions.setUserName(username);
//        mqttConnectOptions.setPassword(password.toCharArray());
//        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
//        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线，但这个方法并没有重连的机制
//        mqttConnectOptions.setKeepAliveInterval(10);
//        // 设置“遗嘱”消息的话题，若客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息。
//        //mqttConnectOptions.setWill("willTopic", WILL_DATA, 2, false);
//        return mqttConnectOptions;
//    }
//
//    /**
//     * MQTT工厂
//     **/
//    @Bean
//    public MqttPahoClientFactory mqttClientFactory() {
//        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
//        factory.setConnectionOptions(getMqttConnectOptions1());
//        return factory;
//    }
//
//    /**
//     * MQTT信息通道（生产者）
//     **/
//    @Bean
//    public MessageChannel mqttOutboundChannel() {
//        return new DirectChannel();
//    }
//
//    /**
//     * MQTT消息处理器（生产者）
//     **/
////    @Bean
////    @ServiceActivator(inputChannel = "mqttOutboundChannel")
////    public MessageHandler mqttOutbound() {
////        MqttPahoMessageHandler mqttPahoMessageHandler = new MqttPahoMessageHandler(clientId + "_producer", mqttClientFactory());
////        mqttPahoMessageHandler.setAsync(true);
////        mqttPahoMessageHandler.setDefaultTopic(defaultTopic);
////        mqttPahoMessageHandler.setAsyncEvents(true); // 消息发送和传输完成会有异步的通知回调
////        //设置转换器 发送bytes数据
////        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter();
////        converter.setPayloadAsBytes(true);
////        return mqttPahoMessageHandler;
////    }
//
//    /**
//     * 配置client,监听的topic
//     * MQTT消息订阅绑定（消费者）
//     **/
//    @Bean
//    public MessageProducer inbound() {
//        List<String> topicList = Arrays.asList(defaultTopic.trim().split(","));
//        String[] topics = new String[topicList.size()];
//        topicList.toArray(topics);
//        MqttPahoMessageDrivenChannelAdapter adapter =
//                new MqttPahoMessageDrivenChannelAdapter(clientId + "_consumer", mqttClientFactory(), topics);
//        adapter.setCompletionTimeout(completionTimeout);
//        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter();
//        converter.setPayloadAsBytes(true);
//        adapter.setConverter(converter);
//        adapter.setQos(0);
//        adapter.setOutputChannel(mqttInputChannel());
//        return adapter;
//    }
//
//    /**
//     * MQTT信息通道（消费者）
//     **/
//    @Bean
//    public MessageChannel mqttInputChannel() {
//        return new DirectChannel();
//    }
//
//    /**
//     * MQTT消息处理器（消费者）
//     **/
//    @Bean
//    @ServiceActivator(inputChannel = "mqttInputChannel")
//    public MessageHandler handler() {
//        return new MessageHandler() {
//            @Override
//            public void handleMessage(Message<?> message) throws MessagingException {
//                //处理接收消息
//                mqttReceiveHandle.handle(message);
//            }
//        };
//    }
//
//
//}
