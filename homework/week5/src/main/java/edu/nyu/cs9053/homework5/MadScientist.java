package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 9/21/14
 * Time: 6:01 PM
 */
public class MadScientist {

    private static final double DECAY_CONSTANT = 1d;

    private final TimeMachine timeMachine;

    public MadScientist(TimeMachine timeMachine) {
        this.timeMachine = timeMachine;
    }

    public static void main(String[] args) {
        // make a MadScientist / TimeMachine and 3 TimeTraveler implementations
        MadScientist madScientist = new MadScientist(new TimeMachine());
        LinearlyTimeTraveler linearlyTimeTraveler = new LinearlyTimeTraveler("LinearMan", 100d);
        DoublyTimeTraveler doublyTimeTraveler = new DoublyTimeTraveler("DoubleMan", 100d);
        ExpolyTimeTraveler expolyTimeTraveler = new ExpolyTimeTraveler("ExpoMan", 100d, DECAY_CONSTANT);
        // experiment on each TimeTraveler
        // a TimeTraveler should always start with 100 years of time travel strength
        // one TimeTraveler implementation should linearly decay (i.e., one year of actual time travel reduces the
        // time traveler's ability by one year)
        //250 multi-thread to speed up the process
        for (int i=0; i<250; i++) {
            madScientist.experiment(linearlyTimeTraveler);
        }
        // one TimeTraveler implementation should decay double the travel value (i.e., one year of actual time travel reduces
        // the time traveler's ability by two years)
        //150 multi-thread
        for (int i=0; i<150; i++) {
            madScientist.experiment(doublyTimeTraveler);
        }
        // one TimeTraveler implementation should have exponential decay with a decay constant inputted by the scientist (see http://en.wikipedia.org/wiki/Exponential_decay)
        //50 multi-thread
        for (int i=0; i<50; i++) {
            madScientist.experiment(expolyTimeTraveler);
        }
        // continue to experiment until all the TimeTraveler's have exhausted their ability to travel
    }

    public void experiment(final TimeTraveler timeTraveler) {
        // invoke the time-machine and print how much time has passed using a callback and adjust the time traveler's ability to travel
        timeMachine.travel(timeTraveler, new TimeTravelCallback(){
            @Override
            public void leaped(Time unit, int amount, boolean ahead) {
                if(!timeTraveler.isExhausted()) {
                    timeTraveler.adjust(unit, amount, ahead);
                    System.out.printf("TimeTraveler %s traveled %d %s %s, %e years remain %n ", timeTraveler.getName(), amount, unit.name(), (ahead ? "into the future" : "into the past"), timeTraveler.getRemainingYearsOfTravel());
                    experiment(timeTraveler);
                }
                else {
                    System.out.printf("TimeTraveler %s is exhausted%n", timeTraveler.getName());
                    return;
                }
            
            }
        });
    }


}
