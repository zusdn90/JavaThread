package com.thread.synchronize;

class thread {
    int check;

    // 동기화 함수가 아님
    public void set_check(int check) {
        if(this.check != 5){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.check = check;
            System.out.println(check);
        } else {
            System.out.println("check 값을 바꿀 수 없어요!");
        }
    }
}

public class AfterSynchronized {
    public static void main(String[] args) {
        thread th1 = new thread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                th1.set_check(5);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                th1.set_check(10);
            }
        });

        // 스레드 실행
        // thread2가 먼저 완료될 경우를 없에기 위해 우선순위 지정
        thread1.setPriority(10);
        thread2.setPriority(1);
        thread1.start();
        thread2.start();
    }
}
