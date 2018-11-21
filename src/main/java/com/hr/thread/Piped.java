package com.hr.thread;

import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author 胡冉
 * @Description: TODO
 * @date 2018/11/2015:32
 * @copyright {@link www.hndfsj.com}
 */
public class Piped {
    public static void main(String[] args) throws IOException {

        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread pring = new Thread(new Pring(in), "PringThread");
        pring.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }

    }

    private static class Pring implements Runnable {
        private PipedReader in;

        public Pring(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.println((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
