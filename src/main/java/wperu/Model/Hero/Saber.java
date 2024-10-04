package wperu.Model.Hero;

import wperu.Model.Stat;

public class Saber extends Hero{
    public Saber(String name)
    {
        super(name);
    }

       public String className() {
        return "Saber";
    }


    public Stat getStatLevel() {
        return new Stat(2, 4, 40);
    }


    public Stat getStartStat() {
        return new Stat(1, 4, 50);
    }

}
