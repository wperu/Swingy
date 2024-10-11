package wperu.Model.Hero;

import wperu.Model.Artifact.Artifact;
import wperu.Model.Stat;
import wperu.Model.Coordinates;
import wperu.Model.Artifact.ArtifactEquip;
import wperu.Model.Direction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;


public abstract class Hero {
    @NotNull
    @Max(20)
    protected String name;

    @Min(1)
    protected int level;
    protected long xp;
    protected Stat baseStat;
    protected Stat endStat;
    protected Artifact weapon;
    protected Artifact armor;
    protected Artifact helm;
    protected Coordinates position;

    protected Hero(String name)
    {
        this.name = name;
        this.level = 1;
        this.xp = 0;
    }

    abstract public String className();
    abstract public Stat getStatLevel();
    abstract public Stat getStartStat();
    
    public Artifact getArtifactEquip(ArtifactEquip equip)
    {
        switch(equip)
        {
            case WEAPON:
                return this.weapon;
            case HELM:
                return this.helm;
            case ARMOR:
                return this.armor;
        }
        return null;
    }

    public void equipArtifact(Artifact artifact)
    {
        switch (artifact.getEquip())
        {
            case WEAPON:
                this.weapon = artifact;
                break;
            case ARMOR:
                this.armor = artifact;
                break;
            case HELM:
                this.helm = artifact;
                break;
        }
        FinalStat();
    }

    public void unequipArtifact(ArtifactEquip artifact)
    {
        switch (artifact) {
            case WEAPON:
                this.weapon = null;
                break;
            case ARMOR:
                this.armor = null;
                break;
            case HELM:
                this.helm = null;
                break;
        }
        FinalStat();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLevel()
    {
        return level;
    }

    public long getXp()
    {
        return xp;
    }

    public void setXp(long xp)
    {
        this.xp = xp;
    }

    public Stat getEndStat()
    {
        return endStat;
    }

    public Artifact getWeapon()
    {
        return weapon;
    }

    public Artifact getArmor()
    {
        return armor;
    }

    public Artifact getHelm()
    {
        return helm;
    }

    public Coordinates getPosition()
    {
        return position;
    }

    public void setPosition(Coordinates position)
    {
        this.position = position;
    }

    public void move(Direction direction)
    {
        switch (direction) {
            case NORTH:
                position.addX(-1);
                break;
            case SOUTH:
                position.addX(1);
                break;
            case EAST:
                position.addX(1);
                break;
            case WEST:
                position.addX(-1);
                break;
        }
    }

    public boolean levelUp(long xp)
    {
        int oldlevel = level;
        this.xp +=xp;
        FinalStat();
        return oldlevel != level;
    }

    //xp for level up (level*1000+(level-1)^2 *450)


    public long nextLevelXp()
    {
        return (int) ((level * 1000) + Math.pow(level -1, 2)*450);
    }

    public void FinalStat()
    {
        level = 1;
        while(nextLevelXp() < xp)
        {
            level += 1;
        }
        baseStat = getStartStat();
        Stat forLevel = getStatLevel();
        endStat = new Stat(
            baseStat.getAttack() + (forLevel.getAttack() * (level - 1)),
            baseStat.getDefense() + (forLevel.getDefense() * (level -1)),
            baseStat.getHitPoint() + (forLevel.getHitPoint() *(level -1)));
        if(weapon != null)
        {
            endStat.add(weapon.getArtifactStat());
        }
        if(armor != null)
        {
            endStat.add(armor.getArtifactStat());
        }
        if(helm != null)
        {
            endStat.add(helm.getArtifactStat());
        }
    }
}

