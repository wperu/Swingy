package wperu.Model.Hero;

import wperu.Model.Stat;

public class Archer extends Hero{
    
    public Archer(String name)
    {
        super(name);
    }

    public String className() {
        return "Archer";
    }


    public Stat getStatLevel() {
        return new Stat(3, 2, 40);
    }


    public Stat getStartStat() {
        return new Stat(3, 3, 40);
    }

    
}
