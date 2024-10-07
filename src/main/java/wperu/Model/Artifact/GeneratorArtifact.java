package wperu.Model.Artifact;

import java.util.Random;

public class GeneratorArtifact {
    protected static Random rand = new Random();

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
}
