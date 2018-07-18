import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by des on 2018/7/4.
 */
public class Test_javaTimer {

    public static void main(String[] args) {
//        timer1();
//        timer2();
//        timer3();
//        timer4();

        timer05();
    }

    private static void timer05() {
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task1 run ...  execute time:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task2 run ...  execute time:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Timer t = new Timer();
        t.schedule(task1, 0,1000);
        t.schedule(task2, 0,1000);
    }


    public static void timer1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer1 当前时间："+ this.scheduledExecutionTime());
            }
        }, 5000);

//        System.out.println("----------------");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer2 当前时间："+ this.scheduledExecutionTime());

            }
        }, new Date(System.currentTimeMillis() + 10000));

//        System.out.println("end "+ System.currentTimeMillis());
    }

    public static void timer2(){

    }

    public static void timer3(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer3: "+ this.scheduledExecutionTime());
            }
        }, 2000, 2000);
    }

    public static void timer4(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer4: "+ this.scheduledExecutionTime());
            }
        }, 0, 3000);
    }

}
