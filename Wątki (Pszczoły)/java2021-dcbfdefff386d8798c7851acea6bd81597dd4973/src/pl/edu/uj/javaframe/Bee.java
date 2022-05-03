package pl.edu.uj.javaframe;

public class Bee extends Thread {
    public String name;
    private final Beehive beehive;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public Bee(int id, Beehive beehive) {
        this.name = "Bee " + id;
        this.beehive = beehive;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(ANSI_CYAN + this.name + " works outside the beehive " + ANSI_RESET);
                sleep(2000 + ((long) (Math.random() * 5000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < beehive.entrances.length; i++) {
                System.out.println(ANSI_RED + this.name + " waits at entrance " + (i + 1) + ANSI_RESET);

                if (!this.beehive.entrances[i]) {
                    synchronized (beehive.entrances[i]) {
                        this.beehive.entrances[i] = true;
                        System.out.println(ANSI_GREEN + this.name + " enters beehive through entrance " + (i + 1) + ANSI_RESET);
                    }
                } else {
                    if (i + 1 == beehive.entrances.length) { // Loop through entrances, checking if one became avaliable
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        i = -1;
                    }

                    continue;
                }

                // Work in beehive
                try {
                    sleep(2000 + ((long) (Math.random() * 5000)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (beehive.entrances[i]) {
                    this.beehive.entrances[i] = false;
                    System.out.println(ANSI_PURPLE + this.name + " exits beehive through entrance " + (i + 1) + ANSI_RESET);
                    break;
                }
            }

            /*
            if (!this.beehive.entrances[0]) {
                synchronized (beehive.entrances[0]) {
                    this.beehive.entrances[0] = true;
                    System.out.println(ANSI_GREEN + this.name + " enters beehive through entrance 1" + ANSI_RESET);

                    try {
                        sleep(2000 + ((long) (Math.random() * 5000)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    this.beehive.entrances[0] = false;
                    System.out.println(ANSI_PURPLE + this.name + " exits beehive through entrance 1" + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + this.name + " waits at entrance 1" + ANSI_RESET);
            }
             */
        }
    }
}
