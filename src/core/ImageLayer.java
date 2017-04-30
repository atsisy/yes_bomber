package core;

import javafx.scene.image.Image;

import java.nio.file.Paths;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class ImageLayer extends Layer {

    private Image image;

    public ImageLayer(double width, double height){
        super(width, height);
        image = null;
    }

    public void LoadImage(String image_path){
        this.image = new Image(Paths.get(image_path).toUri().toString());
    }

    public void DrawImage(double x, double y){
        if(image == null){
            System.err.println("ERROR. TRY TO DRAW NULL IMAGE. \n ImageLayer.java Methods DrawImage.");
        }

        this.graphicsContext.drawImage(image, x, y);

    }

}
