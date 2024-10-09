package wperu.Model.Monster;

import wperu.Model.Stat;

public class Monster {
    protected String name;
    protected MonsterRank rank;
    protected int level;
    protected Stat monsterStat;
  


    protected Monster(String name,MonsterRank rank, int level, Stat monsterStat)
    {
        this.name = name;
        this.rank = rank;
        this.level = level;
        this.monsterStat = monsterStat;
    }

    protected String getName()
    {
        return name;
    }

    protected MonsterRank rank()
    {
        return rank;
    }

    protected int getLevel()
    {
        return level;
    }

    protected Stat getStatMonster()
    {
        return monsterStat;
    }

    
}
