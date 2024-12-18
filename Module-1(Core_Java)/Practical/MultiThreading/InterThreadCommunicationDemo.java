// 3. Use Inter-Thread Communication Methods (wait(), notify(), notifyAll())
package Module_1.MultiThreading;

class Message 
{
    private String message;
    private boolean empty = true;

    // Synchronized method to read the message
    public synchronized String read() {
        while (empty) {
            try {
                // Wait if the message is empty
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        empty = true;
        notifyAll(); // Notify all waiting threads
        return message;
    }

    // Synchronized method to write a message
    public synchronized void write(String message) {
        while (!empty) {
            try {
                // Wait if the message is not empty
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        empty = false;
        this.message = message;
        notifyAll(); // Notify all waiting threads
    }
}

public class InterThreadCommunicationDemo 
{
    public static void main(String[] args) 
    {
        Message message = new Message();

        // Writer thread to write messages
        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] messages = { "Hello", "World", "Synchronization", "in", "Java" };
                for (String msg : messages) {
                    message.write(msg);
                    try {
                        // Sleep for 500 milliseconds
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                message.write("DONE");
            }
        });

        // Reader thread to read messages
        Thread reader = new Thread(new Runnable() {
            @Override
            public void run() {
                for (String latestMessage = message.read(); !latestMessage.equals("DONE"); latestMessage = message.read()) {
                    System.out.println(latestMessage);
                    try {
                        // Sleep for 500 milliseconds
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        // Start both threads
        writer.start();
        reader.start();
    }
}
