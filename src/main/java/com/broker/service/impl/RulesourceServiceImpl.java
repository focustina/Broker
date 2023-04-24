package com.broker.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.broker.pojo.Detectrule;
import com.broker.pojo.Rulesource;
import com.broker.mapper.RulesourceMapper;
import com.broker.service.DetectruleService;
import com.broker.service.RulesourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
@Slf4j
@Service("ruleSourceService")
public class RulesourceServiceImpl extends ServiceImpl<RulesourceMapper, Rulesource> implements RulesourceService {

//    @Autowired
//    DetectruleService detectruleService;

    @Override
    public void saveResult(String result) {

        Rulesource s = JSONObject.parseObject(result, Rulesource.class);
        this.save(s);

//
//        s.getDetectrule().forEach(e -> BeanUtils.copyProperties(s, e));
//
//        log.info("解析后对象为{}",s);
//        detectruleService.saveBatch(s.getDetectrule());



    }
}
