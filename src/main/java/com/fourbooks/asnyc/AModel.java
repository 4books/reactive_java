package com.fourbooks.asnyc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AModel {

    public static void main(String[] args) {
        //동기 blocking
        log.info("Start main");
        //1. getResult를 호출한다.
        var result = getResult();
        //3. 결과를 리턴 받는다.
        var nextValue = result + 1;
        assert nextValue == 1;
        log.info("Finish main");
        //4. 종료
        //Caller는 Callee의 응답이 올때까지 어떠한 일도 할 수 없다.

    }

    public static int getResult(){
        log.info("Start getResult");
        try {
            //2. main 쓰레드는 대기한다.
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        var result = 0;
        try{
            return result;
        } finally {
            log.info("Finish getResult");
        }
    }
}
