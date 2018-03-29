package edu.fgu.dclab.murmur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetReader implements Runnable {
    private BufferedReader in;
    private MessageSink out;

    public NetReader(InputStream in, MessageSink out) {
        this.in = new BufferedReader(
            new InputStreamReader(in)
        );

        this.out = out;
    }

    @Override
    public void run() {
        String line;

        try {
            while ((line = this.in.readLine()) != null) {
                this.out.writeMessage(line);
            }
        }
        catch (IOException e) {
            System.out.println("NetReader I/O Exc eption");
        }
    }
}
