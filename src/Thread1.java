class Thread1 extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
    }
}
