package filed;

import javafx.scene.input.KeyCode;

/**
 * Created by Akihiro on 2017/04/30.
 */
public abstract class Field {

    public Field(){

    }

    abstract public void ReceiveKeyCode(KeyCode code);

}
