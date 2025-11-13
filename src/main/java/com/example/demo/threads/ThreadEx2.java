package com.example.demo.threads;

public class ThreadEx2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            NumberPrinter thread = new NumberPrinter(i);
            thread.start();
            thread.join();
        }
        Thread4 thread4 = new Thread4();
        AlphabetThread alphabetThread = new AlphabetThread();
        SquareThread squareThread = new SquareThread();


        squareThread.start();
        alphabetThread.start();
        thread4.start();
    }
}

class Thread3 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i % 2 != 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}

class Thread4 extends Thread {
    public void run() {
        int num = 5;
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + "*" + i + "=" + num * i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class AlphabetThread extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.println(c);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class SquareThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Square of " + i + " = " + (i * i));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class NumberPrinter extends Thread {
    int number;

    NumberPrinter(int number) {
        this.number = number;
    }

    public void run() {

        System.out.println("Thread " + number + " prints: " + number);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}







