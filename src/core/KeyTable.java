package core;

import javafx.scene.input.KeyCode;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class KeyTable {
    private KeyCode current;

    public KeyTable(){
        current = null;
    }

    public void press(KeyCode code){
        current = code;
    }

    public void release(KeyCode code){
        current = null;
    }

    public boolean isPressed(KeyCode code){
        return current == code;
    }
}
