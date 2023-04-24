package com.broker.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.broker.pojo.Rulerecord;
import com.broker.mapper.RulerecordMapper;
import com.broker.service.RulerecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 规则记录 服务实现类
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@Service("ruleRecordService")
public class RulerecordServiceImpl extends ServiceImpl<RulerecordMapper, Rulerecord> implements RulerecordService {
    @Override
    public void saveResult(String result) {

        Rulerecord s = JSONObject.parseObject(result, Rulerecord.class);
        this.save(s);


    }
}
