package threads;

import functions.Function;

import static functions.Functions.integral;

public class Integrator implements Runnable {

    private Task task;
    private twoSemafors semafor;

    public Integrator(Task task, twoSemafors semafor) {
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

                semafor.startIntegrate();

                Function func = task.getF();
                double left = task.getLeft();
                double right = task.getRight();
                double step = task.getStep();

                try {
                    double result = integral(func, left, right, step);
                    System.out.println("Result " + left + ", " + right + ", " + step + ", " + result);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }

                semafor.endIntegrate();
            }
        } catch (InterruptedException e) {
            System.err.println("Интеграция прервана");
            Thread.currentThread().interrupt();
        }
    }
}
