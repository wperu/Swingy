package wperu.Model.Country;

import java.util.Random;

public class MapFactory {
    protected static Random rand = new Random();
    public Map MapFacto(int levelh)
    {
        int size = (levelh-1)*5+10 -(levelh%2);
        int[][] map = new int[size][size];
        for(int i = 0; i< size; i++)
        {
            for(int j = 0; j < size; j++ )
                map[i][j] = rand.nextInt(Biome.values().length);

        }
    }
}
