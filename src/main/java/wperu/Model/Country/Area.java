package wperu.Model.Country;

import wperu.Model.Monster.Monster;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Area {
    @NotNull
    @Min(0)
    protected int x;

    @NotNull
    @Min(0)
    protected int y;

    @NotNull
    protected Biome biome;

    @Valid
    protected Monster[] monster;
    
    @NotNull
    protected boolean monsterVisible;

    @NotNull
    protected boolean isVisible;

    public Area(@NotNull @Min(0) int x,@NotNull @Min(0) int y,@NotNull Biome biome , Monster[] monsters,
            @NotNull boolean monsterVisible,@NotNull boolean isVisible)
    {
        this.x = x;
        this.y = y;
        this.biome = biome;
        this.monster = monsters;
        this.monsterVisible = monsterVisible;
        this.isVisible = isVisible;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Biome getBiome()
    {
        return biome;
    }

    public Monster[] getMonsters()
    {
        return monster;
    }

    public void setMonster(Monster[] monster)
    {
        this.monster = monster;
    }

    public boolean getMonstersVisible()
    {
        return monsterVisible;
    }

    public boolean getIsVisible()
    {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible)
    {
        this.isVisible = isVisible;
    }

    public void setMonsterVisible(boolean monsterVisible)
    {
        this.monsterVisible = monsterVisible;
    }

    
    
}
