package wperu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0]);
        String a = "console";
        try {
            if (args[0] == a)
        {
            System.out.println("Hello World!");
        }
        else if(args[0] == "gui")
            System.out.println("gui");
            
        } catch (Exception e) {
           System.out.println("truc");
        }
        
    }
}
