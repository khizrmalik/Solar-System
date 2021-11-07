public class Moons extends Planets
{
    private double cord, cora, angle; 

    public Moons(String n, double d, double a, double di, String c, double sp, double cd, double ca)
    {
        super(n, d, a, di, c, sp);
        angle = a;
        cord = cd;
        cora = ca;
        speed = sp;
    }

    public double getCORD()
    {
        return cord;
    }

    public double getCORA()
    {
        return cora;
    }

    public double getAngle()
    {
        return angle;
    }

    public void move()
    {
        angle = angle + 3;
        cora = cora + (speed*0.2);
    }
}
