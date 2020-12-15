package com.mufg.demo.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "position" })
@XmlRootElement(name = "OutputResponse")
public class OutputResponse {

    @XmlElement(name = "Position", required = true)
    private Position position;

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "direction", "x", "y" })
    public static class Position {

        @XmlElement(name = "Direction", required = true)
        private String direction;

        @XmlElement(name = "X", required = true)
        private Integer x;

        @XmlElement(name = "Y", required = true)
        private Integer y;

    }
}
