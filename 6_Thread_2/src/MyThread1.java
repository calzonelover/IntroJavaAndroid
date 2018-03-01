public class MyThread1 extends Thread{
    private int _i = 1;
    private int _sum = 0;

    @Override
    public void run(){// Override abstract method from Thread
        System.out.println("Thread is running...");

        do {
            this._sum = this._sum + _i;
            System.out.printf("Thread 2 : i = %d sum = %d \n"
                    , _i, this._sum);
            _i++;
        } while (_i<=100);
    }
}
