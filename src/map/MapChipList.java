package map;

import javafx.scene.image.Image;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class MapChipList {

    private Image[] mapchips;

    public MapChipList(String file_name){

        mapchips = new Image[MapChipID.Size()];

        try (BufferedReader in = new BufferedReader(new FileReader(new File(file_name)))){
            String line;
            int i = 0;

            while ((line = in.readLine()) != null) {
                if(i == 0){
                    mapchips = new Image[Integer.valueOf(line)];
                }else {
                    mapchips[i] = new Image(Paths.get(line).toUri().toString());
                }
                i++;
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }

    }

    public Image GetMapChipImage(MapChipID id){
        try {
            return mapchips[MapChipID.ToInteger(id)];
        }catch (NullPointerException e){
            return null;
        }

    }

}
