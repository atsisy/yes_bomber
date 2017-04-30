package core;

import filed.Field;
import filed.StartField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class Main extends Application {

    public static Field CurrentField;

    @Override
    public void start(Stage stage){

        stage.setWidth(1366);
        stage.setHeight(768);

        AnchorPane root = new AnchorPane();

        StartField start_field = new StartField("start_wallpaper.png");
        start_field.AddRoot(root);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> CurrentField.ReceiveKeyCode(event.getCode()));
        stage.setScene(scene);

        start_field.SortLayer();

        CurrentField = start_field;

        stage.show();

    }
}
