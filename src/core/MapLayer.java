package core;

import map.Map;
import map.MapChipID;
import map.MapChipList;

import static value.Value.MAPCHIP_HEIGHT;
import static value.Value.MAPCHIP_WIDTH;

/**
 * Created by Akihiro on 2017/04/30.
 */
public class MapLayer extends Layer {

    public MapLayer(MapChipList list, Map map){
        super(map.getWidth() * MAPCHIP_WIDTH, map.getHeight() * MAPCHIP_HEIGHT);
        map.DrawMapChips(list, this);
    }


}
