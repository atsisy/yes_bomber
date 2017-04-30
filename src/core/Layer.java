package core;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import static value.Value.WINDOW_HEIGHT;
import static value.Value.WINDOW_WIDTH;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class Layer {
    protected Canvas canvas;
    protected GraphicsContext graphicsContext;

    public Layer(double width, double height){
        canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    /*
    * 指定したグラフィックレイヤーをすべて消す関数
     */
    public void eraseLayer(){
        this.graphicsContext.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    /*
    * アクティブレイヤーの変更を行うメソッド
     */
    public void beForward(){
        canvas.toFront();
    }
}
