package com.mufg.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mufg.demo.data.BotOperateRequestData;
import com.mufg.demo.service.BotOperateService;

@RestController
@RequestMapping(APIConstants.BOT)
public class ApiResources {

    private final BotOperateService botOperateService;

    @Autowired
    public ApiResources(final BotOperateService botOperateService) {
        this.botOperateService = botOperateService;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(path = APIConstants.OPERATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> operate(@RequestBody BotOperateRequestData requestData) {
        this.botOperateService.operate(requestData);
        return new ResponseEntity("Request Accepted", HttpStatus.OK);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(path = APIConstants.LOCATION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLocation() {
        final String location = this.botOperateService.getLocation();
        return new ResponseEntity(location, HttpStatus.OK);
    }
}
