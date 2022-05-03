package pl.edu.uj.javaframe;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class EchoServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        final int threadPool = 3;
        FindPrimes [] threads = new FindPrimes[threadPool];
        int threadCounter = 0;

        while (true) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Accept failed: 6666");
                System.exit(-1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            if (threadCounter < threadPool) {
                threads[threadCounter] = new FindPrimes(out, in);
                threads[threadCounter++].start();
            } else {
                for (int i = 0; i < threadPool; i++) {
                    System.out.println(i);
                    if (!threads[i].isAlive()) {
                        threads[i] = null;
                        threads[i] = new FindPrimes(out, in);
                        threads[i].start();
                    } else if (i == threadPool - 1) {
                        Thread.sleep((1000));
                        i = -1;
                    }
                }
            }
        }
        /*
        out.println(in.readLine());
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
         */
    }
}