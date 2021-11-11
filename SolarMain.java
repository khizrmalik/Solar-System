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
        
        for (int j = 0; j < 250; j++)
        {
            int location = rn.nextInt(190 -170 + 1) + 170;
            int rotation = rn.nextInt(360) + 1;
            solarObjects.add(new SolarSystemObject("asteroids", location, rotation, 2, "#A9A9A9"));
        }

        solarObjects.add(new Planets("Mercury", 50, 0, 10, "#964b00", 1)); //Mercury
        solarObjects.add(new Planets("Venus", 90, 175, 8, "#8B8000", 2)); //Venus
        solarObjects.add(new Planets("Earth", 115, 125, 12, "#436380", 3)); //Earth
        solarObjects.add(new Planets("Mars", 150, 25, 12, "#BC2732", 4)); //Mars
        solarObjects.add(new Planets("Jupiter", 225, 150, 20, "#e36e4b", 5)); //Jupiter
        solarObjects.add(new Planets("Saturn", 300, 50, 16, "#C2B280", 6)); //Saturn
        solarObjects.add(new Planets("Uranus", 335, 100, 10, "#30D5C8", 7)); //Uranus
        solarObjects.add(new Planets("Neptune", 350, 75, 12, "#00008b", 8)); //Neptune
            
        for (int j = 0; j < 500; j++)
        {
            location = rn.nextInt(750) + 1;
            rotation = rn.nextInt(360) + 1;
            solarObjects.add(new SolarSystemObject("Star", location, rotation, 2, "WHITE")); //Stars
        }

        solarObjects.add(new Moons("Earth Moon", 13, 0, 5, "GREY", 3, 115, 125, "Earth")); //Earths Moon
        solarObjects.add(new Moons("Jupiter Moon1", 23, 45, 5, "GREY", 5, 225, 150, "Jupiter")); //Jupiter Moon 1
        solarObjects.add(new Moons("Jupiter Moon2", 23, 90, 5, "GREY", 5, 225, 150, "Jupiter")); //Jupiter Moon 2
        solarObjects.add(new Moons("Jupiter Moon3", 23, 165, 5, "GREY", 5, 225, 150, "Jupiter")); //Jupiter Moon 3
        solarObjects.add(new Moons("Jupiter Moon 4", 23, 245, 5, "GREY", 5, 225, 150, "Jupiter")); //Jupiter Moon 4

        for (int j = 5; j < 100; j++)
        {
            int location = rn.nextInt(25 -20 + 1) + 20;
            int rotation = rn.nextInt(360) + 1;
            solarObjects.add(new Moons("Saturn", 20, rotation, 2, "#A9A9A9", 6, 300, 50, "Saturn"));
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