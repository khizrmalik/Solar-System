public class SolarSystemObject
{
   private double distance, angle, diameter, cord, cora, speed;
   private String colour, name, parentName;
 
   public SolarSystemObject(String n, double d, double a, double di, String c)
   {
       name = n;
       distance = d;
       angle = a;
       diameter = di;
       colour = c;
   }
   
   public String getName()
   {
        return name;
   }

   public double getDistance()
   {
       return distance;
   }
 
   public double getAngle()
   {
       return angle;
   }
 
   public double getDiameter()
   {
       return diameter;
   }
 
   public String getColour()
   {
       return colour;
   }

   public double getCORD()
   {
       return cord;
   }
 
   public double getCORA()
   {
       return cora;
   }

   public double getSpeed()
   {
       return speed;
   }

   public String getPN()
   {
       return parentName;
   }

   public void move()
   {
       angle = angle + 0.4;
   }
}
