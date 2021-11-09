/**
 * This class is a parent class that holds the basic variables of a Solar Object
 * @author Khizr Malik
 */
public class SolarSystemObject
{
   private double distance, angle, diameter, cord, cora, speed;
   private String colour, name, parentName;

    /**
     * A constructor that takes parameters of a solar object
     * @param n name
     * @param d distance
     * @param a angle
     * @param di diameter
     * @param c colour
     */
   public SolarSystemObject(String n, double d, double a, double di, String c)
   {
       name = n;
       distance = d;
       angle = a;
       diameter = di;
       colour = c;
   }
   
   /**
    * A get method that returns the value of a parameter of a solar object
    */
   public String getName()
   {
        return name;
   }

   /**
    * A get method that returns the value of a parameter of a solar object
    */
   public double getDistance()
   {
       return distance;
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
   public double getDiameter()
   {
       return diameter;
   }
 
   /**
    * A get method that returns the value of a parameter of a solar object
    */
   public String getColour()
   {
       return colour;
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
   public double getSpeed()
   {
       return speed;
   }

   /**
    * A get method that returns the value of a parameter of a solar object
    */
   public String getPN()
   {
       return parentName;
   }

   /**
    * A method, when called, moves the solar object a certain number of values
    */
   public void move()
   {
       angle = angle + 0.4;
   }
}
