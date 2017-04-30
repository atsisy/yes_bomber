package map;

import core.MapLayer;

import java.io.*;
import java.util.StringTokenizer;

import static value.Value.MAPCHIP_HEIGHT;
import static value.Value.MAPCHIP_WIDTH;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class Map {

    int width;
    int height;
    private MapChipID[][] map_matrix;

    public Map(String file_name){

        try (BufferedReader in = new BufferedReader(new FileReader(new File(file_name)))){
            String line;
            int i = 0;
            while((line = in.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                if(i == 0){
                    width = Integer.valueOf(tokenizer.nextToken());
                    height = Integer.valueOf(tokenizer.nextToken());
                    map_matrix = new MapChipID[width][height];
                }else{
                    for(int n = 0;n < width;n++){
                        map_matrix[n][i-1] = MapChipID.ToEnum(Integer.valueOf(tokenizer.nextToken()));
                    }
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

    public void DrawMapChips(MapChipList list, MapLayer layer){
        for(int x = 0;x < width;x++){
            for(int y = 0;y < height;y++){
                layer.getGraphicsContext().drawImage(list.GetMapChipImage(map_matrix[x][y]), x * MAPCHIP_WIDTH, y * MAPCHIP_HEIGHT);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
