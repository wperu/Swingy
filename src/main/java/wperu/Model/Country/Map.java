package wperu.Model.Country;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

public class Map {

    @Min(9)
    protected int size;
    @Min(1)
    protected int level;

    @NotNull
    @Valid
    protected Area[][] map;

    public Map(int level, int size,Area[][] map)
    {
        this.level = level;
        this.size = size;
        this.map = map;
    }

    public int getLevel()
    {
        return level;
    }

    public int getSize()
    {
        return size;
    }

    public Area[][] getMap()
    {
        return map;
    }

    public void delMonster(int x, int y)
    {
        map[x][y].setMonster(null);
    }

    public void setAreaVisible(int x, int y)
    {
        map[x][y].setIsVisible(true);
    }

    public void setMonsterIsVisible(int x, int y)
    {
        map[x][y].setMonsterVisible(true);
    }
    
    
}
