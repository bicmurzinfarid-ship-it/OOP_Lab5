import functions.*;
import functions.basic.*;
import threads.*;

import static functions.Functions.integral;

public class Main {

    public static void nonThread(){
        int num = 100;
        for (int i = 0;i<num;i++) {
            double base = 11 * Math.random();
            Log log = new Log(base);
            double left = 101 * Math.random();
            double right = (((200 - 100) + 1) * Math.random()) + 100;
            double step = Math.random();
            Task task = new Task(log, left, right, step,num);

            System.out.println("Source " + left + ", " + right + ", " + step);
            try{
                double resualt = integral(log,left,right,step);
                System.out.println("Resualt " + left + ", " + right + ", " + step+", "+resualt);
            }catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }

        }

    }

    public static void simpleThreads(){
        System.out.println("Многопоточное ");
        Task task = new Task();
        task.setNum(100);
        Thread simpleGeneratorThread = new Thread(new SimpleGenerator(task));
        Thread simpleIntegratorThread = new Thread(new SimpleIntegrator(task));

        simpleGeneratorThread.start();

        simpleIntegratorThread.start();

        simpleGeneratorThread.setPriority(Thread.NORM_PRIORITY);
        simpleIntegratorThread.setPriority(Thread.NORM_PRIORITY);
    }

    public static void complicatedThreads(){
        System.out.println("Многопоточное с симофором");
        Task task = new Task();
        task.setNum(100);
        twoSemafors semafor = new twoSemafors();
        Thread generatorThread = new Thread(new Generator(task,semafor));
        Thread integratorThread = new Thread(new Integrator(task,semafor));

        generatorThread.start();
        integratorThread.start();

        generatorThread.setPriority(Thread.MAX_PRIORITY);
        integratorThread.setPriority(Thread.MAX_PRIORITY);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        generatorThread.interrupt();
        integratorThread.interrupt();
    }

    public static void main(String[] args) {

        Function sins = new Sin();
        double result = integral(sins, 0, Math.PI, 0.01);
        System.out.println("Интеграл sin на [0,pi] = " + result);

        //nonThread();

        //simpleThreads();

        complicatedThreads();

    }
}