package edu.fgu.dclab.murmur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SceneChat {
    private Scene mScene = null;

    private TextArea textArea = null;
    private TextField textField = null;

    private NetWriter writer = null;

    public SceneChat() {
        BorderPane contentPane = new BorderPane();

        contentPane.setTop(getStatusBar());
        contentPane.setCenter(getMessagePane());
        contentPane.setBottom(getInputPane());

        mScene = new Scene(contentPane, 400, 200);
    } // SceneChat()

    public Scene getScene() {
        return mScene;
    }

    public TextArea getBoard() {
        return this.textArea;
    }

    public TextField getInputField() {
        return this.textField;
    }

    public void setWriter(NetWriter writer) {
        this.writer = writer;
    }

    private ScrollPane getMessagePane() {
        ScrollPane scrollPane = new ScrollPane();

        this.textArea = new TextArea();
        this.textArea.setEditable(false);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        scrollPane.setContent(this.textArea);

        return scrollPane;
    } // getMessagePane()

    private BorderPane getInputPane() {
        Button btnSend = new Button("送 出");

        this.textField = new TextField();

        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                writer.sendMessage();
            }
        });

        BorderPane inputPane = new BorderPane();

        inputPane.setCenter(this.textField);
        inputPane.setRight(btnSend);

        return inputPane;
    } // getInputPane()

    private HBox getStatusBar() {
        Label id = new Label("房間號碼：");
        Label number = new Label("目前人數：");

        return new HBox(id, number);
    } // getStatusBar()
}
