package pl.edu.uj.javaframe;

class Chef extends Thread {
    private Restaurant restaurant;
    private WaitPerson waitPerson;

    public Chef(Restaurant r, WaitPerson w) {
        restaurant = r;
        waitPerson = w;
        start();
    }

    public void run() {
        while (true) {
            if (restaurant.order == null) {
                restaurant.order = new Order();
                System.out.print("Order up! ");
                synchronized (waitPerson) {
                    waitPerson.notify();
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
