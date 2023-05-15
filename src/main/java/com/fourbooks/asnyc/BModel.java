package com.fourbooks.asnyc;


import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class BModel {

    public static void main(String[] args) {
        //비동기 Blocking
        log.info("Start main");
        //main은 getResult가 결과를 구하고 callback을 실행하기 전까지 아무것도 할 수 없다.
        getResult(integer -> {
            var nextValue = integer + 1;
            assert nextValue == 1;
        });

        log.info("Finish main");
    }

    public static void getResult(Consumer<Integer> cb){
        log.info("Start getResult");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        var result = 0;
        cb.accept(result);
        log.info("Finish getResult");
    }
}
