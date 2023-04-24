package com.broker.service;

import com.broker.pojo.Rulehandle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
public interface RulehandleService extends IService<Rulehandle> {
    void saveResult(String result);

}
