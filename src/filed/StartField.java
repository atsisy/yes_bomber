package filed;

import core.ImageLayer;
import core.SelectLayer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import static core.Main.manager;
import static value.Value.WINDOW_HEIGHT;
import static value.Value.WINDOW_WIDTH;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class StartField extends Field {
    private ImageLayer image_layer;
    private SelectLayer select_layer;

    private double x, y;
    private short select_menu_index;

    public StartField(String image_path){
        image_layer = new ImageLayer(WINDOW_WIDTH, WINDOW_HEIGHT);
        select_layer = new SelectLayer(WINDOW_WIDTH, WINDOW_HEIGHT);

        image_layer.LoadImage(image_path);
        image_layer.DrawImage(0, 0);

        x = (WINDOW_WIDTH / 2) - 150;
        y = WINDOW_HEIGHT / 2;

        select_menu_index = 0;

        SelectLayerRedraw();
    }

    public void SortLayer(){
        image_layer.getCanvas().toFront();
        select_layer.getCanvas().toFront();
    }

    public void AddRoot(AnchorPane pane){
        pane.getChildren().addAll(image_layer.getCanvas(), select_layer.getCanvas());
    }

    @Override
    public void ReceiveKeyCode(KeyCode code){
        if(code.equals(KeyCode.UP)){
            PrevMenu();
        }else if(code.equals(KeyCode.DOWN)){
            NextMenu();
        }else if(code.equals(KeyCode.ENTER)){
            switch (select_menu_index){
                case 0:
                    manager.ChangeToBattleField();
                    break;
                case 1:
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }

    private void NextMenu(){
        select_layer.getGraphicsContext().clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        if(y < 500){
            select_menu_index++;
            y += 100;
        }else{
            select_menu_index = 0;
            y = WINDOW_HEIGHT / 2;
        }
        SelectLayerRedraw();
    }

    private void PrevMenu(){
        select_layer.getGraphicsContext().clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        if(y > (WINDOW_HEIGHT / 2)){
            select_menu_index--;
            y -= 100;
        }else{
            select_menu_index = 2;
            y += 200;
        }
        SelectLayerRedraw();
    }

    private void SelectLayerRedraw(){
        select_layer.getGraphicsContext().setFont(new Font(30));
        select_layer.getGraphicsContext().fillText("START", x, WINDOW_HEIGHT / 2);
        select_layer.getGraphicsContext().fillText("RESTART", x, (WINDOW_HEIGHT / 2) + 100);
        select_layer.getGraphicsContext().fillText("QUIT", x, (WINDOW_HEIGHT / 2) + 200);

        select_layer.DrawRect(x, y - 30, 300, 40);
    }

    public void ClearAll(){
        image_layer.EraseLayer();
        select_layer.EraseLayer();
    }
}
