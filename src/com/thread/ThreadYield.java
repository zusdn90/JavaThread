package com.thread;

class ThreadA extends Thread {
    private boolean stop = false;
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void run() {
        while(!stop){
            if (flag) {
                System.out.println("ThreadA is working");
            } else {
                // flag가 false가 되면 다른 스레드에게 실행 양보
                Thread.yield();
            }
        }
    }
}

class ThreadB extends Thread {
    private boolean stop = false;
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void run() {
        while(!stop){
            if (flag) {
                System.out.println("ThreadB is working");
            } else {
                // flag가 false가 되면 다른 스레드에게 실행 양보
                Thread.yield();
            }
        }
    }
}



public class ThreadYield {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        // Thread A,B 시작
        threadA.start();
        threadB.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // Thread B만 실행
        threadA.setFlag(false);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // Thread A만 실행
        threadA.setFlag(true);
        threadB.setFlag(false);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // Thread 종료
        threadA.setStop(true);
        threadB.setStop(true);



    }
}
