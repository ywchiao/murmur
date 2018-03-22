package edu.fgu.dclab.murmur;

import java.io.IOException;
import java.net.Socket;

public class Net {
    private boolean connected = false;

    private Socket clientSocket;

    private NetReader reader = null;
    private NetWriter writer = null;

    public boolean connect(String ip, int port) {
        connected = false;

        try {
            this.clientSocket = new Socket(ip, port);

            this.writer = new NetWriter(
                clientSocket.getOutputStream()
            );

            this.reader = new NetReader(
                clientSocket.getInputStream()
            );

            System.out.println("ready");
            connected = true;
        }
        catch (IOException e) {
            System.out.println("Connection refused.");
        }

        return connected;
    }

    public NetReader getReader() {
        return this.reader;
    }

    public NetWriter getWriter() {
        return this.writer;
    }

    public boolean isConnected() {
        return connected;
    }
}
