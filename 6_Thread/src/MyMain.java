public class MyMain {
    public static void main(String[] args){

        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        Thread t3 = new Thread(new MyThread1());

        t1.start();
        t2.start();
        t3.start();
    }
}
