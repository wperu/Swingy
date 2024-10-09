package wperu.Model.Monster;

import wperu.Model.Stat;
import java.util.Random;
import jakarta.validation.constraints.Min;


public class MonsterFactory {
    protected static Random rand = new Random();
    protected static MonsterFactory mFactory = new MonsterFactory();

    protected String[] styles = {
        "blue" , "red" , "iron" , "Dark"
    };

    protected String[] jobs = {
        "Soldier" , "Caster" , "Archer" ,"rider"
    };

    protected String[] typeMonster = {
        "Goblin" , "Orc" , "Vampire" ,"Slime" , "Skeleton", "Dragon"
    };

    protected MonsterFactory(){}

    protected String name()
    {
        String Monster;
        Monster = typeMonster[rand.nextInt(typeMonster.length)];
        
        String type = null;
        
        if(Monster == "Slime" || Monster == "Dragon")
        {
            type = styles[rand.nextInt(styles.length)];    
        }
        else
        {
            type = jobs[rand.nextInt(jobs.length)];
        }
        return (type + " " + Monster);
    }

    protected MonsterRank mRank()
    {
        double rank = rand.nextDouble();
        if(rank >= 0.30)
            return MonsterRank.KNIGHT;
        else if(rank >= 0.50)
            return MonsterRank.GENERAL;
        else if(rank >= 0.75)
            return MonsterRank.KING;
        else if(rank >= 90)
            return MonsterRank.ANCESTRAL;
        else
            return MonsterRank.SOLDAT;
    }

    protected int boostRank(MonsterRank rank)
    {
        int boost = 0;

        if(rank.equals(MonsterRank.KNIGHT))
            boost = 2;
        else if(rank.equals(MonsterRank.GENERAL))
            boost = 4;
        else if(rank.equals(MonsterRank.KING))
            boost = 6;
        else
            boost = 8;
        return boost;
    }

    public Monster generate(@Min(1) int level)
    {
        String name = this.name();
        MonsterRank rank = this.mRank();
        int boost = this.boostRank(rank);
        boost += level;
        Stat stat = new Stat(1,1,10);
        double statAvantage = rand.nextDouble();
        if(statAvantage > 0.33)
        {
            int attack = boost;
            int defense = rand.nextInt((int) (boost * 0.5));
            int hitPoints = boost * 10;
            stat.setAttack(attack);
            stat.setDefense(defense);
            stat.setHitPoints(hitPoints);  
        }
        else if(statAvantage > 0.66)
        {
            int defense = boost;
            int attack = rand.nextInt((int) (boost * 0.5));
            int hitPoints = boost * 10;
            stat.setAttack(attack);
            stat.setDefense(defense);
            stat.setHitPoints(hitPoints); 
        }
        else
        {
            int hitPoints = boost * 10 +  rand.nextInt((int) (boost * 0.8));
            int attack = rand.nextInt((int) (boost * 0.5));
            int defense = rand.nextInt((int) (boost * 0.5));
            stat.setAttack(attack);
            stat.setDefense(defense);
            stat.setHitPoints(hitPoints); 
        }
        return new Monster(name, rank, level, stat);
    }

    public static MonsterFactory getFactory()
    {
        return mFactory;
    }


    
}
