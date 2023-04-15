package com.broker.Controller;




import com.broker.Entity.DetectRule;
import com.broker.Mapper.DetectRuleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库插入数据
 */
@Slf4j
@RestController
@RequestMapping("/detectrule")
public class DetectRuleController {
    @Autowired
    DetectRuleMapper mapper;
    @PostMapping
    public Boolean saveDetectRule(@RequestBody DetectRule detectRule){
        log.warn("detectRule {}",detectRule);
        int i = mapper.insert(detectRule);
        return i == 1;
    }
}
