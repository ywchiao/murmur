package edu.fgu.dclab.murmur;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetReader implements Runnable {
    private BufferedReader in;
    private TextArea textArea;

    public NetReader(InputStream in) {
        this.in = new BufferedReader(
            new InputStreamReader(in)
        );
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        String line;

        try {
            while ((line = this.in.readLine()) != null) {
                this.textArea.appendText(line + "\n");
            }
        }
        catch (IOException e) {
            System.out.println("NetReader I/O Exception");
        }
    }
}
