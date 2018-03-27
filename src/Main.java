import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
       timer();
    }

    private static void timer(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,13);
        calendar.set(Calendar.MINUTE,10);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String cmd = "cmd /c start E:\\back_db.bat";
                try {
                    Process ps = Runtime.getRuntime().exec(cmd);
                    ps.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },time,1000*60);
    }
}
