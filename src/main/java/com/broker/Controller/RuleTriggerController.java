package com.broker.Controller;


import com.broker.Entity.RuleTrigger;
import com.broker.Mapper.RuleTriggerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("ruletrigger")
public class RuleTriggerController {
    @Autowired
    RuleTriggerMapper mapper;
    @PostMapping
    public Boolean saveruletrigger(@RequestBody RuleTrigger ruletrigger){
        log.warn("ruletrigger {}",ruletrigger);
        int i = mapper.insert(ruletrigger);
        return i == 1;
    }
}
