package com.broker.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.broker.pojo.Rulehandle;
import com.broker.mapper.RulehandleMapper;
import com.broker.pojo.Rulesource;
import com.broker.service.RulehandleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@Service("ruleHandleService")
public class RulehandleServiceImpl extends ServiceImpl<RulehandleMapper, Rulehandle> implements RulehandleService {
    public void saveResult(String result) {

        Rulehandle s = JSONObject.parseObject(result, Rulehandle.class);
        this.save(s);

    }
}
