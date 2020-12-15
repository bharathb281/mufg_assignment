package com.mufg.demo.exception;

public class ProvidedPositionIsNotConsidered extends RuntimeException {

    public ProvidedPositionIsNotConsidered(String msg) {
        super(msg);
    }
}
