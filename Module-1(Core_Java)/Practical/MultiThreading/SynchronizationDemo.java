// 2. Implement Thread Synchronization Using synchronized Blocks or Methods
package Module_1.MultiThreading;
class SharedCounter 
{
    private int count = 0;

    // Synchronized method to increment the count
    public synchronized void increment() {
        count++;
    }

    // Synchronized method to get the count
    public synchronized int getCount() {
        return count;
    }
}

public class SynchronizationDemo 
{
    public static void main(String[] args) 
    {
        SharedCounter counter = new SharedCounter();

        // Create first thread to increment the counter
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });

        // Create second thread to increment the counter
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        try
        {
            // Wait for both threads to finish
            t1.join();
            t2.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final count: " + counter.getCount());
    }
}
