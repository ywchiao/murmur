package edu.fgu.dclab.murmur;

import javafx.application.Application;
import javafx.stage.Stage;

public class Murmur extends Application {

    private SceneChat sceneChat;
    private SceneConnect sceneConnect;
    private Stage stage;
    private Net netIO = new Net();

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setTitle("MurMur 聊天室");

        sceneChat = new SceneChat();
        sceneConnect = new SceneConnect(this);

        stage.setScene(sceneConnect.getScene());

        stage.show();
    } // start()

    public void connect(String ip, int port) {
        if (netIO.connect(ip, port)) {
            netIO.connectSink(sceneChat);
            netIO.connectSource(sceneChat);

            this.stage.setScene(sceneChat.getScene());
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    } // main()
}

// Murmur.java