package filed;

import javafx.scene.layout.AnchorPane;

import static core.Main.CurrentField;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class FieldManager {

    private StartField start_field;
    private BattleField battle_field;

    public FieldManager(String image_path){
        start_field = new StartField(image_path);
        battle_field = new BattleField();
    }

    public void AddToRoot(AnchorPane root){
        start_field.AddRoot(root);
    }

    public void SortStartFieldLayer(){
        start_field.SortLayer();
    }

    public void Start(){
        CurrentField = start_field;
    }
}
