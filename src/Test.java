class Test extends Thread {
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        Test t = new Test();
        t.start();
    }
}
