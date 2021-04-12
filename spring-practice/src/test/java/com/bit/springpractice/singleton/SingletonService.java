package com.bit.springpractice.singleton;

public class SingletonService {
    private static final  SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
        //프라이빗 설정으로 객체 외생성 차단
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
