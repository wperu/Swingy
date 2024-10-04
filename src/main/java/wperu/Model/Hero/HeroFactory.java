package wperu.Model.Hero;

public class HeroFactory {

    public static Hero newHero(String type, String name) {
        if (type.equalsIgnoreCase("Archer")) {
            return new Archer(name);
        } else if (type.equalsIgnoreCase("Caster")) {
            return new Caster(name);
        } else if (type.equalsIgnoreCase("Saber")) {
            return new Saber(name);
        }
        return null;
    }
}
