package com.thread.synchronize;

public class BeforeSynchronized {
    static int check = 10;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                check = 20;
            }
        });

        thread1.setName("첫번째 스레드 - check 값을 20으로 바꿉니다.");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(check);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.setName("두번째 스레드 - check를 프린트해봅니다.");

        System.out.println(thread1.getName());
        System.out.println(thread2.getName());

        // 스레드 실행
        thread1.start();
        thread2.start();
    }
}
