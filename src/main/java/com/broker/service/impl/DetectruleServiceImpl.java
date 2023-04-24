package com.broker.service.impl;

import com.broker.Client.MQTTSubsribe;
import com.broker.Client.PushCallback;
import com.broker.pojo.Detectrule;
import com.broker.mapper.DetectruleMapper;
import com.broker.service.DetectruleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@Service("detectRuleService")
public class DetectruleServiceImpl extends ServiceImpl<DetectruleMapper, Detectrule> implements DetectruleService {

}
