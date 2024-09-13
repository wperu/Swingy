package wperu.Model;

public class Coordinates {
    protected int x;
    protected int y;

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void addX(int x)
    {
        this.x += x;
    }

    public void addY(int y)
    {
        this.y += y;
    }
}
