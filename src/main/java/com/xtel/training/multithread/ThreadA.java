package com.xtel.training.multithread;

public class ThreadA {
    public static void main(String[] args) {
        ThreadB tb = new ThreadB();
        tb.start();

        synchronized (tb) {
            try {
                System.out.println("Wait tb complete !");
                tb.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Total: " + tb.total);
        }
    }

    static class ThreadB extends Thread {
        int total;
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    total += i;
                }
                notify();
            }
        }
    }
}
