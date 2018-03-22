package edu.fgu.dclab.murmur;

import javafx.scene.control.TextField;

import java.io.OutputStream;
import java.io.PrintWriter;

public class NetWriter {
    private PrintWriter out;
    private TextField textField;

    public NetWriter(OutputStream out) {
        this.out = new PrintWriter(out, true);
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public void sendMessage() {
        String message = this.textField.getText();
        this.textField.clear();

        System.out.println(message);

        this.out.println(message);
    }
}
