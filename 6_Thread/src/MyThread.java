public class MyThread implements Runnable{
    private int x = 10;

    @Override
    public void run(){
        System.out.println("Thread is running...");

        for (int i = 0; i < 10; i++){
            this.showInfo(i);
//            System.out.printf("Thread 0 : i is %d \n",i+x);
        }
    }

    private void showInfo(int y){
        System.out.printf("Thread 0 : y is %d \n ", y + x);
    }
}
