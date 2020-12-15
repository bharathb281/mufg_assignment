package com.mufg.demo.service;

import com.mufg.demo.data.BotOperateRequestData;

public interface BotOperateService {

    public void operate(BotOperateRequestData botOperateRequestData);
    
    public String getLocation();
}
