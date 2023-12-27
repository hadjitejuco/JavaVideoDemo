class Thread5 implements Runnable {
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted!");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Thread5(), "InterruptedThread");
        t.start();

        try {
            Thread.sleep(1000); // Main thread sleeps for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt(); // Main thread interrupts the sleeping thread
    }
}
