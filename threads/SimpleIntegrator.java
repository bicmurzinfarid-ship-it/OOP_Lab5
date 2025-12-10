package threads;

import functions.Function;

import static functions.Functions.integral;

public class SimpleIntegrator implements Runnable {

    private Task task;

    public SimpleIntegrator(Task task) {
        this.task = task;
    }

    @Override
    public void run() {

        for (int i = 0; i < task.getNum(); i++) {

            Function func;
            double left, right, step;

            synchronized (task) {
                while (task.getF() == null) {
                    try {
                        task.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                func = task.getF();
                left = task.getLeft();
                right = task.getRight();
                step = task.getStep();


                try {
                    double result = integral(func, left, right, step);
                    System.out.println(
                            "Resualt " + left + ", " + right + ", " + step + ", " + result
                    );
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
                task.clear();
            }
        }
    }
}
