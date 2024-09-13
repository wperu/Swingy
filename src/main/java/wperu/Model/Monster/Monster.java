package wperu.Model.Monster;

import wperu.Model.Stat;

public class Monster {
    protected String name;
    protected int level;
    protected long xp;
    protected Stat monsterStat;
  


    protected Monster(String name, int level, long xp, Stat monsterStat)
    {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.monsterStat = monsterStat;
    }

    protected String getName()
    {
        return name;
    }

    protected int getLevel()
    {
        return level;
    }

    protected long getXp()
    {
        return xp;
    }

    protected Stat getStatMonster()
    {
        return monsterStat;
    }
}
