package sampleThreads;

public class TestRunnableDemo {

    public static void main(String[] args) {
        Runnable hello = new RunnableTest("Hello there");
        Thread thread1 = new Thread(hello);
        thread1.setName("HelloThread");
        thread1.setDaemon(true); // thread becomes background (low priority)
        System.out.println("Thread1 starts to say hello");
        thread1.start();

        Runnable bye = new RunnableTest("Bye there");
        Thread thread2 = new Thread(bye);
        thread2.setName("ByeThread");
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true); // background thread
        System.out.println("Thread2 starts to say bye");
        thread2.start();

        System.out.println("main is done");
    }
}
