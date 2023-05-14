package com.fourbooks.asnyc;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class ConsumerTest {

    public static void main(String[] args) {

        //함수형 인터페이스는 호출한 쓰레드에서 실행된다
        var consumer = getConsumer();
        consumer.accept(1);

        var consumerAsLamda = getConsumerAsLamda();
        consumerAsLamda.accept(1);

        handleConsumer(consumer);
    }

    public static Consumer<Integer> getConsumer() {
        Consumer<Integer> returnValue = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                log.info("value in interface : {}", integer);
            }
        }; //Consumer를 구현한 익명 클래스
        return returnValue;
    }

    public static Consumer<Integer> getConsumerAsLamda(){
        return integer -> log.info("value in lamda: {}", integer); //위에 Consumer를 lamda로 만든 것
    }

    public static void handleConsumer(Consumer<Integer> consumer){
        log.info("handleConsumer");
        consumer.accept(1);
    }

}
