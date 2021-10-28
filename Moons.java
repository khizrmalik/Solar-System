public class Moons extends Planets
{
    private double cord, cora, angle; 

    public Moons(double d, double a, double di, String c, int no, double cd, double ca)
    {
        super(d, a, di, c, no);
        angle = a;
        cord = cd;
        cora = ca;
        pNo = no;
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
        cora = cora + (pNo*0.2);
    }
}
