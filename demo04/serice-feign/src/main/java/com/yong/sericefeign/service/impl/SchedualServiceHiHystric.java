package com.yong.sericefeign.service.impl;

import com.yong.sericefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {


    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry 对不起" + name;
    }
}
