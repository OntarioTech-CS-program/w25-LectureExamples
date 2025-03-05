package sampleThreads;

public class TestThreadDemo {
    public static void main(String[] args) {
        System.out.println("Starting thread_1");
        Thread thread_1 = new ThreadDemo(15);
        thread_1.start();

        try {
            thread_1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread_1 interrupting");
        }

        System.out.println("Starting thread_2");
        Thread thread_2 = new ThreadDemo(20);
        thread_2.start();

        System.out.println("Main ended");
    }
}
