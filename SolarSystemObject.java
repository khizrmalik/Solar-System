public class SolarSystemObject
{
   private double distance, angle, diameter, cord, cora;
   private String colour;
 
   public SolarSystemObject(double d, double a, double di, String c)
   {
       distance = d;
       angle = a;
       diameter = di;
       colour = c;
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
 
   public void move()
   {
       angle = angle + 0.4;
   }
}
