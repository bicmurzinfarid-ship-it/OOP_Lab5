package threads;

public class twoSemafors {
    private final Semafor choice = new Semafor(1);
    private final Semafor dataReady = new Semafor(0);
    public void startGenerate() throws InterruptedException {
        choice.lock();
    }

    public void endGenerate() throws InterruptedException {
        dataReady.unlock();
    }

    public void startIntegrate() throws InterruptedException {
        dataReady.lock();
    }

    public void endIntegrate() throws InterruptedException {
        choice.unlock();
    }
}