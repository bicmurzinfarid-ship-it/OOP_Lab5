package threads;

import functions.basic.Log;

public class Generator extends Thread implements Runnable {
    private Task task;
    private twoSemafors semafor;

    public Generator(Task task, twoSemafors semafor) {
        this.task = task;
        this.semafor = semafor;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < task.getNum(); i++) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }

                semafor.startGenerate();

                double base = 11 * Math.random();
                Log log = new Log(base);
                double left = 101 * Math.random();
                double right = (((200 - 100) + 1) * Math.random()) + 100;
                double step = Math.random();

                task.setF(log);
                task.setLeft(left);
                task.setRight(right);
                task.setStep(step);

                System.out.println("Source " + left + ", " + right + ", " + step);

                semafor.endGenerate();
            }
        } catch (InterruptedException e) {
            System.err.println("Генерация прервана");
            Thread.currentThread().interrupt();
        }
    }
}


