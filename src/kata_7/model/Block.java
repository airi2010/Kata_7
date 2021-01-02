package kata_7.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Block {
    public static final int MAX = 7;
    private int x;
    private int y;
    private final Timer timer;
    private final List<Observer> observers=new ArrayList<>();
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.timer = new Timer();
    }
    
    public void left(){
        if (this.x == 1) return;
        this.x--;
        changed();
    }
    
    public void right(){
        if (this.x == MAX) return;
        this.x++;
        changed();
    }
    
    public void up(){
        if (this.y == MAX) return;
        this.y++;
        changed();
    }
    
    public void down(){
        if (this.y == 1) return;
        this.y--;
        changed();
    }
    public void time(){
        this.timer.schedule(task(), 1000, 500);
    }
    public void stop(){
        this.timer.cancel();
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }

    private TimerTask task() {
        return new TimerTask(){
            @Override
            public void run(){
                double r = Math.random();
                if (r >= 0.20) return;
                else if (r >= 0.15) left();
                else if (r >= 0.10) right();
                else if (r >= 0.05) up();
                else if (r >= 0.00) down();
                for (Observer observer : observers) {
                    observer.changed();
                }
            }
        };
    }

    public void register(Observer observer) {
        observers.add(observer);
    }
    
    private void changed(){
        for (Observer observer : observers) {
            observer.changed();
        }
    }

   public void moveTo(int x, int y) {
      this.x=x;
      this.y=y;
      changed();
    }
    public interface Observer {
        void changed();
    }
}
