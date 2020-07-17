package com.thread;

public class ThreadPriority {
    public static void main(String[] args) {

        // main 스레드 우선순위
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i < 200000000; i++) {}
                System.out.println("1");
            }
        });

        thread1.setName("첫번째 실행 스레드");
        System.out.println(thread1.getName());

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 200000000; i++) {}
                System.out.println("2");
            }
        });

        thread2.setName("두번째 실행 스레드");
        System.out.println(thread2.getName());

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 200000000; i++) {}
                System.out.println("3");
            }
        });

        thread3.setName("세번째 실행 스레드");
        System.out.println(thread3.getName());

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 200000000; i++) {}
                System.out.println("4");
            }
        });

        thread4.setName("네번째 실행 스레드");
        System.out.println(thread4.getName());

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 200000000; i++) {}
                System.out.println("5");
            }
        });

        thread5.setName("다섯번째 실행 스레드");
        System.out.println(thread5.getName());

        // 우선순위 설정
        // 숫자가 높을수록 우선순위가 높음
        thread1.setPriority(Thread.MIN_PRIORITY);   // 우선순위 1
        thread2.setPriority(7);
        thread3.setPriority(8);
        thread4.setPriority(9);
        thread5.setPriority(Thread.MAX_PRIORITY);

        // 스레드 실행
        // 우선순위가 높다고 해서 항상 먼저 나오는 것은 아님=> 우선순위가 높은 스레드는 단지 실행 상태를 더 많이 가지도록 스케줄링 당하는 것이기 때문임
        // 실행할 때마다 결과가 약간씩 바뀌지만 우선순위가 높은 스레드가 먼저 실행되는 경우가 빈번함
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
