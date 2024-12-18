//1.Create and Run Multiple Threads Using the Thread Class
package Module_1.MultiThreading;
public class MultiThreadDemo 
{
    public static void main(String[] args) 
    {
        // Create first thread by extending the Thread class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 1 - Count: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Create second thread by extending the Thread class
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2 - Count: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}
