package wperu.Model.Hero;

import wperu.Model.Stat;

public class Caster extends Hero {

        public Caster(String name){
            super(name);
        }

 
        public String className() {
            return "Caster";
        }

   
        public Stat getStatLevel() {
            return new Stat(4, 2, 30);
        }


        public Stat getStartStat() {
            return new Stat(4 , 2, 30);
        }

      
}
