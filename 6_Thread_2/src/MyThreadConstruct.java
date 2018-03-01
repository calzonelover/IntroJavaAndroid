public class MyThreadConstruct extends Thread {
    private int _i = 1;
    private int _sum = 0;
    private int _max;

    // constructure
    public MyThreadConstruct(int max) {
        this._max = max;
    }

    @Override
    public void run() {// Override abstract method from Thread
        System.out.println("Thread is running...");

        do {
            this._sum = this._sum + this._i;
            System.out.printf("Thread 3 : i = %d sum = %d \n"
                    , this._i, this._sum);
            _i++;
        } while (this._i <= this._max);
    }
}