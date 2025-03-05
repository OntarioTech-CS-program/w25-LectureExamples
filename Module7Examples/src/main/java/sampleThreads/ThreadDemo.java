package sampleThreads;

public class ThreadDemo extends Thread {
    private int number;

    ThreadDemo(int number){
        this.number = number;
    }

    // do stuff to happen in parallel
    public void run(){
        int counter = 0;
        int numInt = 0;

        do {
            numInt = counter+10;
            System.out.println(this.getName() + " prints " + numInt);
            counter++;
        }while (numInt < number);
        System.out.println(this.getName() + " finished printing " + counter + " times.");


    }
}
