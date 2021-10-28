public class Planets extends SolarSystemObject
{
    private double angle, distance;
    int pNo;
 
    public Planets(double d, double a, double di, String c, int no)
    {
        super(d, a, di, c);
        angle = a;
        distance = d;
        pNo = no;
    }

    public double getAngle()
    {
        return angle;
    }

    public void move()
    {
        angle = angle + (pNo*0.2);
    }

}
