package sampleThreads;

public class RunnableTest implements Runnable {
    String message;

    public RunnableTest(String message){
        this.message = message;
    }
    // parallel stuff in this method
    public void run() {
        while(true){
            System.out.println(message);
        }
    }
}
