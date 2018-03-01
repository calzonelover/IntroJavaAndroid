public class MyThread1 implements Runnable{
    private int x = 10;

    public void run(){
        System.out.println("Thread is running...");

        for (int i = 0; i < 10; i++){
            System.out.printf("Thread 1 : i is %d \n",i*x);
        }
    }
}
