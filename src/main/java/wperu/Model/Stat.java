package wperu.Model;

public class Stat {
    protected int attack;

    protected int defense;

    protected int hitPoints;

    public Stat(int attack, int defense, int hitPoints)
    {
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getHitPoint()
    {
        return hitPoints;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }

    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }

    public void add(Stat artifact)
    {
        this.attack += artifact.attack;
        this.defense += artifact.defense;
        this.hitPoints += artifact.hitPoints;
    }

}
