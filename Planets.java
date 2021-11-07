public class Planets extends SolarSystemObject
{
    private double angle, distance;
    double speed;
 
    public Planets(String n, double d, double a, double di, String c, double sp)
    {
        super(n, d, a, di, c);
        angle = a;
        distance = d;
        speed = sp;
    }

    public double getAngle()
    {
        return angle;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void move()
    {
        angle = angle + (speed*0.2);
    }

}
