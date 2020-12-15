package com.mufg.demo.service;

import com.mufg.demo.data.BotOperateRequestData;
import com.mufg.demo.data.OutputResponse;

public interface BotOperateService {

    public OutputResponse operate(BotOperateRequestData botOperateRequestData);
    
    public OutputResponse getLocation();
}
