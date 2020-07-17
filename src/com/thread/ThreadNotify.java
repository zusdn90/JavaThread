package com.thread;

// 공유 객체 클래스
class WorkObject {
    public synchronized void methodA() {
        System.out.println("ThreadA의 methodA() 작업 실행");
        notify();   // 일시 정지 상태에 있는 ThreadB를 실행 대기 상태로 전환
        try {
            wait(); // ThreadA를 일시 정지 상태로 전환
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("ThreadB의 methodB() 작업 실행");
        notify();   // 일시 정지 상태에 있는 ThreadA를 실행 대기 상태로 전환
        try {
            wait(); // ThreadB를 일시 정지 상태로 전환
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ThreadM extends Thread {
    private WorkObject workObject;

    public ThreadM(WorkObject workObject) {
        this.workObject = workObject;   // 공유 객체 저장
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            workObject.methodA();   // 공유 객체의 methodA() 호출
        }
    }
}

class ThreadN extends Thread {
    private WorkObject workObject;

    public ThreadN(WorkObject workObject) {
        this.workObject = workObject;   // 공유 객체 저장
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            workObject.methodB();   // 공유 객체의 methodA() 호출
        }
    }
}

public class ThreadNotify {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject(); // 공유 객체 생성

        ThreadM threadM = new ThreadM(sharedObject);
        ThreadN threadN = new ThreadN(sharedObject);

        threadM.start();
        threadN.start();
    }
}
