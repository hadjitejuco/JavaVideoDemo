class Message {
    private String message;
    private boolean empty = true;

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Producer implements Runnable {
    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = { "Line 1", "Line 2", "Line 3", "Done" };

        for (int i = 0; i < messages.length; i++) {
            message.put(messages[i]);
        }
    }
}

class Consumer implements Runnable {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    public void run() {
        for (String msg = message.take(); !msg.equals("Done"); msg = message.take()) {
            System.out.println(msg);
        }
    }
}

public class Thread4 {
    public static void main(String[] args) {
        Message msg = new Message();
        (new Thread(new Producer(msg))).start();
        (new Thread(new Consumer(msg))).start();
    }
}
