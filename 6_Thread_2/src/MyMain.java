public class MyMain {

    public static void main(String[] args){

        System.out.println("Start --> \n");

        Thread myThread;

        for (int i = 0; i < 5; i++){
            myThread = new Thread(new MyThreadConstruct(i*2));
            myThread.start();
        }

        System.out.println("--> End \n");
    }
}


//    // Ex 1
//    public static void main(String[] args){
//
////        Thread t1 = new Thread(new MyThread());
//        Thread t2 = new Thread(new MyThread1());
//        Thread t3 = new Thread(new MyThreadConstruct(90));
//
////        t1.start();
//        t2.start();
//        t3.start();
//    }
//}
