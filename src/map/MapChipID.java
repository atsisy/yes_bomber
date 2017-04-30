package map;

/**
 * Created by Akihiro on 2017/04/30.
 */
public enum  MapChipID {
    Grass,
    Stone,
    NULLNULL
    ;

    public static int Size(){
        return 2;
    }

    public static int ToInteger(MapChipID id){
        switch (id){
            case Grass:
                return 0;
            case Stone:
                return 1;
            default:
                return -1;
        }
    }

    public static MapChipID ToEnum(int id){
        switch (id){
            case 0:
                return Grass;
            case 1:
                return Stone;
            default:
                return NULLNULL;
        }
    }

}
