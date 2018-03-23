package edu.fgu.dclab.murmur;

import java.io.OutputStream;
import java.io.PrintWriter;

public class NetWriter implements MessageSink {
    private PrintWriter out;

    public NetWriter(OutputStream out) {
        this.out = new PrintWriter(out, true);
    }

    public void writeMessage(String message) {
        this.out.println(message);
    }
}
