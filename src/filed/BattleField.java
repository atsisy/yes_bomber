package filed;

import javafx.scene.input.KeyCode;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class BattleField extends Field {

    public BattleField(){
        super();
    }

    @Override
    public void ReceiveKeyCode(KeyCode code){
        if(code.equals(KeyCode.UP)){
        }else if(code.equals(KeyCode.DOWN)){
        }else if(code.equals(KeyCode.ENTER)){
            System.out.println("a");
        }
    }

}
