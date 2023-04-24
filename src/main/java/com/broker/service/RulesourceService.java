package com.broker.service;

import com.broker.pojo.Rulesource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bailing
 * @since 2023-04-19
 */
public interface RulesourceService extends IService<Rulesource> {

    void saveResult(String result);

}
