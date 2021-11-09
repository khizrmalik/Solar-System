import java.util.Random;
import java.util.ArrayList;

/** A class to implement the gui and take in inputs from the user to insert solar objects into the solar system
 * @author Khizr Malik
 */
public class SolarMain implements SolarSystemController
{
    Random rn = new Random();

    SolarSystemGUI gui = new SolarSystemGUI();

    SolarSystem mW = new SolarSystem(800, 800); //creating a window for the solar system
    SolarSystemObject sun = new SolarSystemObject("Sun", 0, 0, 60, "YELLOW");
    SolarSystemObject sun2 = new SolarSystemObject("Sun",0, 0, 50, "#FFE484");
    SolarSystemObject sun3 = new SolarSystemObject("Sun",0, 0, 40, "#FFCC33");
    SolarSystemObject sun4 = new SolarSystemObject("Sun",0, 0, 30, "#FFC000");
    SolarSystemObject sun5 = new SolarSystemObject("Sun",0, 0, 20, "#FC9601");
    SolarSystemObject sun6 = new SolarSystemObject("Sun",0, 0, 10, "#FFC000");

    ArrayList<SolarSystemObject> solarObjects = new ArrayList<>();

    int location, rotation;
    double spd, cord, cora;

    /**
     * A main constructor that 
     * displays the gui
     * Randomly scatters solarobjects as stars
     * Contains a while loop that is continuous and inserts any solarobject inputted by the user in the gui
     * Inserts the Sun which is made with multiple solar objects to make it look more realistic
     * A method from the SolarSystem class to refresh the display after every loop
     */

    public SolarMain()
    {
        gui.addSolarSystemController(this);    
        
        for (int j = 0; j < 500; j++)
        {
            location = rn.nextInt(750) + 1;
            rotation = rn.nextInt(360) + 1;
            solarObjects.add(new SolarSystemObject("Star", location, rotation, 2, "WHITE")); //Stars
        }
        
        while(true) //Loop to initiate the planets orbitting of the sun
        {
            for (int i = 0; i < solarObjects.size(); i++)
            {
                if (!(solarObjects.get(i) instanceof Moons))
                    mW.drawSolarObject(solarObjects.get(i).getDistance(), solarObjects.get(i).getAngle(), solarObjects.get(i).getDiameter(), solarObjects.get(i).getColour());
                else
                    mW.drawSolarObjectAbout(solarObjects.get(i).getDistance(), solarObjects.get(i).getAngle(), solarObjects.get(i).getDiameter(), solarObjects.get(i).getColour(), solarObjects.get(i).getCORD(), solarObjects.get(i).getCORA());
                
                if (!(solarObjects.get(i).getName().equals("Star"))) //if its a star than don't move
                    solarObjects.get(i).move();
            }

            mW.drawSolarObject(sun.getDistance(), sun.getAngle(), sun.getDiameter(), sun.getColour());
            mW.drawSolarObject(sun2.getDistance(), sun2.getAngle(), sun2.getDiameter(), sun2.getColour());
            mW.drawSolarObject(sun3.getDistance(), sun3.getAngle(), sun3.getDiameter(), sun3.getColour());
            mW.drawSolarObject(sun4.getDistance(), sun4.getAngle(), sun4.getDiameter(), sun4.getColour());
            mW.drawSolarObject(sun5.getDistance(), sun5.getAngle(), sun5.getDiameter(), sun5.getColour());
            //Sun created at the centre of the solar system
            
            mW.finishedDrawing(); //To refresh the display every increment
        }

    }

    /**
     * An add method that inserts solar objects (orbitting the sun) with the parameters provided by the user
     * @param name name of solarobject
     * @param orbitalDistance Distance of solar object from sun
     * @param intialAngle Initial angle of the solar object
     * @param size size of the object
     * @param speed speed of orbitting
     * @param colour colour of the object
     */
    @Override
    public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour) 
    {
        solarObjects.add(new Planets(name, orbitalDistance, initialAngle, size, colour, speed));
    }

    /**
     * An add method that inserts solar objects (orbitting another solar object) with the parameters provided by the user
     * @param name name of the solar object
     * @param orbitalDistance Distance of solar object from other
     * @param intialAngle Initial angle of object
     * @param size size of object
     * @param speed speed of orbitting
     * @param colour colour of object
     * @param parentName name of the object that this one is orbitting
     */
    @Override
    public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour, String parentName) 
    {
        for (int i = 0; i < solarObjects.size(); i++)
        {
            if (solarObjects.get(i).getName().equals(parentName))
            {
                cord = solarObjects.get(i).getDistance();
                cora = solarObjects.get(i).getAngle();
                spd = solarObjects.get(i).getSpeed();
            }
        }
        solarObjects.add(new Moons(name, orbitalDistance, initialAngle, size, colour, spd, cord, cora, parentName));
    }

    /**
     * An add method that removes any solar objects with the parameters provided by the user
     * @param name name of the solar object that needs to be removed
     */
    @Override
    public void remove(String name) 
    {
        for (int i = 0; i < solarObjects.size(); i++)
        {
            if (solarObjects.get(i).getName().equals(name) || ((solarObjects.get(i) instanceof Moons) && solarObjects.get(i).getPN().equals(name)))
            {
                solarObjects.remove(i);
            }
        }
    }
}