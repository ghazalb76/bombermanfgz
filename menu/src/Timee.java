import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ZAHRA on 16/07/2017.
 */
public class Timee {

    int secondPassed=0;
    Timer mytimer = new Timer();
    TimerTask task= new TimerTask() {
        @Override
        public void run() {
            secondPassed++;
            System.out.println(secondPassed);
        }
    };
    public void start(){
        mytimer.scheduleAtFixedRate(task,1000,1000);
    }



}

