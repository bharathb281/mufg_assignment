package com.mufg.demo.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BotOperateRequestData {

    public Position position;
    public List<Move> move = null;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Position {

        private String direction;
        private Integer x;
        private Integer y;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Move {

        private String o;
        private Integer l;
        private Integer f;
        private Integer r;
        private Integer b;
    }
}
