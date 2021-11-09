/**
 * A subclass of SolarSystemObject that adds any unique variables and methods that a planet needs
 * @author Khizr Malik
 */
public class Planets extends SolarSystemObject
{
    private double angle, distance;
    double speed;
    
    /**
     * A constructor for solar objects that need to orbit the sun taking the extra parameter speed
     * @param n name
     * @param d distance
     * @param a angle
     * @param di diameter
     * @param c colour
     * @param sp speed
     */
    public Planets(String n, double d, double a, double di, String c, double sp)
    {
        super(n, d, a, di, c);
        angle = a;
        distance = d;
        speed = sp;
    }

    /**
    * A get method that returns the value of a parameter of a solar object
    */
    public double getAngle()
    {
        return angle;
    }

    /**
    * A get method that returns the value of a parameter of a solar object
    */
    public double getSpeed()
    {
        return speed;
    }

    /**
    * A method, when called, moves the solar object the speed value provided every increment of the loop
    */
    public void move()
    {
        angle = angle + (speed*0.2);
    }

}
