/**
 * A subclass of Planets that adds any unique variables and methods that a Moon needs
 * @author Khizr Malik
 */
public class Moons extends Planets
{
    private double cord, cora, angle; 
    private String parentName;

    /**
     * A constructor for solar objects that need to orbit other solar objects 
     * Taking the extra parameters speed, centre of rotation diameter and angle, and parent object name
     * @param n name
     * @param d distance
     * @param a angle
     * @param di diameter
     * @param c colour
     * @param sp speed
     * @param cd centre of rotation distance
     * @param ca centre of rotation angle
     * @param pN Parent name
     */
    public Moons(String n, double d, double a, double di, String c, double sp, double cd, double ca, String pN)
    {
        super(n, d, a, di, c, sp);
        angle = a;
        cord = cd;
        cora = ca;
        speed = sp;
        parentName = pN;
    }

    /**
    * A get method that returns the value of a parameter of a solar object
    */
    public double getCORD()
    {
        return cord;
    }

    /**
    * A get method that returns the value of a parameter of a solar object
    */
    public double getCORA()
    {
        return cora;
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
    public String getPN()
    {
        return parentName;
    }

    /**
    * A method, when called, moves the solar object the speed value provided every increment of the loop
    */
    public void move()
    {
        angle = angle + 3;
        cora = cora + (speed*0.2);
    }
}
