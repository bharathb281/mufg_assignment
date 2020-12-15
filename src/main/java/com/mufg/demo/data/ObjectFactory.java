package com.mufg.demo.data;

import javax.xml.bind.annotation.XmlRegistry;

import com.mufg.demo.data.OutputResponse.Position;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {}
      
    public OutputResponse createOutputData() {
        return new OutputResponse();
    }
    
    public Position createPositionData() {
        return new OutputResponse.Position();
    }
}
