package wperu.Model.Artifact;

import java.util.Random;
import wperu.Model.Stat;


public class GeneratorArtifact {
    protected static Random rand = new Random();
    protected static GeneratorArtifact generator = new GeneratorArtifact();

    protected String[] artifactType = {
        "Divine" , "Dragon" , "Cursed" , "Royal" , "Mitril", "Enchanted"
    };


    protected String[] helmetType = {
        "Hat", "Helmet" , "Mask" , "Circlet" 
    };

    protected String[] armorType = {
        "Robe", "Armor", "Vest"
    };
    
    protected String[] weaponType = {
        "Scepter" , "Sword" , "Bow" 
    };

    protected GeneratorArtifact(){}

    protected String name(ArtifactEquip equip){
        String type = null;
        if(rand.nextBoolean())
        {
           type = artifactType[rand.nextInt(artifactType.length)]; 
        }
        String typeEquip;
        if(equip.equals(ArtifactEquip.HELM))
        {
            typeEquip = helmetType[rand.nextInt(helmetType.length)];
        }
        else if(equip.equals(ArtifactEquip.ARMOR))
        {
            typeEquip = armorType[rand.nextInt(armorType.length)];
        }
        else
        {
            typeEquip = weaponType[rand.nextInt(weaponType.length)];
        }
        
        return (type != null ? type + " " + typeEquip : typeEquip);
    }
    
    protected ArtifactEquip equip()
    {
        double item = rand.nextDouble();
        if(item >= 0.33)
            return ArtifactEquip.ARMOR;
        else if(item >= 0.66)
            return ArtifactEquip.HELM;
        else
            return ArtifactEquip.WEAPON;
    }

    protected Rarity rarity()
    {
        double rare = rand.nextDouble();
        if(rare >= 0.25)
            return Rarity.RARE;
        else if(rare >= 0.50)
            return Rarity.EPIC;
        else if(rare >= 0.75)
            return Rarity.LEGENDARY;
        else
            return Rarity.COMMON;
    }

    protected Stat StatArtifact(int level, Rarity rarity, ArtifactEquip equip)
    {
        Stat stat = new Stat(0, 0, 0);
        
        int rarityEffect; 
        
        if(rarity.equals(Rarity.LEGENDARY))
            rarityEffect = 10;
        else if(rarity.equals(Rarity.EPIC))
            rarityEffect = 5;
        else if(rarity.equals(Rarity.RARE))
            rarityEffect = 2;
        else
            rarityEffect = 0;
        
        //TODO test different resultat  
        int hintstat = (level - 1) *  2 + 8 + rarityEffect;
        if(equip.equals(ArtifactEquip.ARMOR))
        {
            int defense = rand.nextInt((int)(hintstat * 0.5));
            stat.setDefense(defense);
        }
        else if (equip.equals(ArtifactEquip.HELM))
        {
            int hitPoints = rand.nextInt((int)(hintstat * 0.5));
            stat.setHitPoints(hitPoints);
        }
        else
        {
            int attack = rand.nextInt((int)(hintstat * 0.5));
            stat.setAttack(attack);
        }
        return stat;
    }

    protected Artifact generate(int level)
    {
        ArtifactEquip equip = this.equip();
        String name = this.name(equip);
        Rarity rarity = this.rarity();
        Stat statArtifact = this.StatArtifact(level, rarity, equip);
        return new Artifact(name, rarity, statArtifact, equip);
    }
    public static GeneratorArtifact getGeneratorArtifact()
    {
        return generator;
    }
}


