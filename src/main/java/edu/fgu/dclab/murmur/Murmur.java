package edu.fgu.dclab.murmur;

import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Murmur extends Application {

    private SceneChat sceneChat;
    private SceneConnect sceneConnect;
    private Net netHandler = new Net();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MurMur 聊天室");

        sceneChat = new SceneChat();

        sceneConnect = new SceneConnect(this);

        stage.setScene(sceneConnect.getScene());

        stage.show();
    } // start()

    public void connect(Stage stage, String ip, int port) {
        if (netHandler.connect(ip, port)) {
            setChattingBoard(sceneChat.getBoard(), netHandler.getReader());
            setInputField(sceneChat.getInputField(), netHandler.getWriter());

            stage.setScene(sceneChat.getScene());
        }
    }

    private void setChattingBoard(TextArea textArea, NetReader reader) {
        reader.setTextArea(textArea);

        new Thread(reader).start();
    }

    private void setInputField(TextField textField, NetWriter writer) {
        writer.setTextField(textField);

        sceneChat.setWriter(writer);
    }

    public static void main(String[] args) {
        Application.launch(args);
    } // main()
}

// Murmur.java