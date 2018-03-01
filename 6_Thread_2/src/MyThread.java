public class MyThread extends Thread {
    private int _i = 1;
    private int _multiply = 1;

    @Override
    public void run() { // Override abstract method from Thread
        System.out.println("Thread is running...");

        do {
            this._multiply = this._multiply*_i;
            System.out.printf("Thread 1 : i = %d multiply = %d \n"
                    , _i, this._multiply);
            _i++;
        } while (_i <= 10);
    }
}