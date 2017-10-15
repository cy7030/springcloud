package com.hcfc.sericefeign.service.impl;

import com.hcfc.sericefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {


    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry 对不起" + name;
    }
}
