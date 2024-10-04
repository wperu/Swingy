package wperu.Model.Artifact;

import wperu.Model.Stat;

public class Artifact {

    protected String name;

    protected Rarity rarity;

    protected Stat artifactStat;

    protected ArtifactEquip equip;

    public Artifact(String name, Rarity rarity, Stat artifactStat, ArtifactEquip equip){
        this.name = name;
        this.rarity = rarity;
        this.artifactStat = artifactStat;
        this.equip = equip;
    }

    public String getName(){
        return name;
    }

    public Rarity getRarity()
    {
        return rarity;
    }

    public Stat getArtifactStat()
    {
        return artifactStat;
    }

    public ArtifactEquip getEquip(){
        return equip;
    }

    
}
