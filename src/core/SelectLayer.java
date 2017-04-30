package core;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class SelectLayer extends Layer {

    public SelectLayer(double width, double height){
        super(width, height);
    }

    public void DrawRect(double x, double y, double width, double height){
        this.graphicsContext.strokeRect(x, y, width, height);
    }
}
