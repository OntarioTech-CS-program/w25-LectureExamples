package horseRace;

public class HorseRaceDemo {

    public HorseRaceDemo(int numHorses, String[] horseNames){
        Horse[] horses = new Horse[numHorses];

        //creating the horses for the race
        for(int i = 0; i < numHorses; i++){
            horses[i] = new Horse(horseNames[i]);
        }

        System.out.println("Ready...");
        System.out.println("Set...");
        System.out.println("Go...");

        // starting our horses
        for(int i = 0; i < numHorses; i++){
            horses[i].start();
        }

    }
    public static void main(String[] args) {
        String [] names = new String[] {"HorseN1","Victorious", "Monday", "Fantastic", "Marvelous", "Oreo"};
        HorseRaceDemo race;
        race = new HorseRaceDemo(names.length, names);
    }
}
