package core;

import filed.Field;
import filed.FieldManager;
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

        FieldManager manager = new FieldManager("start_wallpaper.png");
        manager.AddToRoot(root);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> CurrentField.ReceiveKeyCode(event.getCode()));
        stage.setScene(scene);

        manager.SortStartFieldLayer();
        manager.Start();

        stage.show();

    }
}
