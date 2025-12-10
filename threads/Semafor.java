package threads;

public class Semafor {
    private int flag;

    public Semafor (int flag){
        this.flag = flag;
    }
    public synchronized void lock()  throws InterruptedException{
        while(flag == 0){
            wait();
        }
        --flag;
    }
    public synchronized void unlock(){
        ++flag;
        notify();
    }
}
