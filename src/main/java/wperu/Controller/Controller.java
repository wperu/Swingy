package wperu.Controller;

import javax.swing.JFrame;

public abstract class Controller {
   
    protected Swingy swingy;

    protected Controller(Swingy swingy)
    {
        this.swingy = swingy;
    }

    protected final boolean handleCommand(String input)
    {
        if(input == null)
        {
            return true;
        }
    if(input.equalsIgnoreCase("h") || input.equalsIgnoreCase("help"))
    {
        new Help(this).render();
        return true;
    }
    else if (input.equalsIgnoreCase("home"))
    {
        swingy.useSaveController();
        return true;
    }
    else if (input.equalsIgnoreCase("quit"))
    {
        swingy.quit();
        return true;
    }
        else if (input.startsWith("set-display"))
        {
            String[] parts = input.split(" ");
            if(parts.length == 2)
            {
                Mode mode = Mode.fromString(parts[1]);
                if(mode != null)
                {
                    CurrentDisplay.setMode(mode);
                    swingy.getUi().show();
                    swingy.runOnce();
                }
                else
                    System.out.println("Invalide set-display " + parts[1] + " , expedted console or gui");
            }
            else
                System.out.println("Invalid set-display argument, missing argument");
            return true;
        }
        return false;
    }

    abstract public void reset();

    abstract public boolean handle(String event);

    abstract public void run();

    public final JFrame getFrame()
    {
        return swingy.getUi().getFrame();
    }

    public final UI getUi()
    {
        return swingy.getUi();
    }
}
