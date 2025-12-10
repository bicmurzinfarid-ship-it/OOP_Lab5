package threads;

import functions.basic.Log;

public class SimpleGenerator implements Runnable {

    private Task task;

    public SimpleGenerator(Task task) {
        this.task = task;
    }

    @Override
    public void run() {

        for (int i = 0; i < task.getNum(); i++) {

            double base = 11 * Math.random();
            Log log = new Log(base);
            double left = 101 * Math.random();
            double right = (((200 - 100) + 1) * Math.random()) + 100;
            double step = Math.random();

            synchronized (task) {
                while (task.getF() != null) {
                    try {
                        task.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println("Source " + left + ", " + right + ", " + step);
                task.setTask(log, left, right, step);
            }


        }
    }
}
