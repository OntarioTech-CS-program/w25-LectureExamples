package horseRace;

public class Horse extends Thread{

    public Horse(String name){
        super(name);
    }

    // parallel stuff happens
    @Override
    public void run() {
        int ITERATIONS = 1000000000;
        for (int i = 0; i < ITERATIONS; i++) {
            if((i%10000000) == 0){
                System.out.println(getName() + " : " + (i/10000000)+"m");
            }
        }
        System.out.println(getName() + " is done ");
    }
}
