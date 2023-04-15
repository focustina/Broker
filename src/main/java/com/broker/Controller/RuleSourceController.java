package com.broker.Controller;


import com.broker.Entity.RuleSource;
import com.broker.Mapper.RuleSourceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/rulesource")
public class RuleSourceController {
    @Autowired
    RuleSourceMapper mapper;
    @PostMapping
    public Boolean saveRuleSource(@RequestBody RuleSource rulesource){
        log.warn("rulesource {}",rulesource);
        int  i = mapper.insert(rulesource);
        return i == 1;
    }
}




