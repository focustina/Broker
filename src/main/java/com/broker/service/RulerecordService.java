package com.broker.service;

import com.broker.Client.MQTTSubsribe;
import com.broker.pojo.Rulerecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 规则记录 服务类
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
public interface RulerecordService extends IService<Rulerecord> {


    void saveResult(String result);
}
