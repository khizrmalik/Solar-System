import java.util.Random;

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

    SolarSystemObject[] solarObjects = new SolarSystemObject[708];
    Planets[] moons = new Moons[100];

    int location, rotation, adderM;
    int adder = 500;
    double spd, cord, cora;
    String remName;

    public SolarMain()
    {
        gui.addSolarSystemController(this);    
        
        for (int j = 0; j < 500; j++)
        {
            location = rn.nextInt(750) + 1;
            rotation = rn.nextInt(360) + 1;
            solarObjects[j] = new SolarSystemObject("Star", location, rotation, 2, "WHITE"); //Stars
        }

        // for (int j = 500; j < 700; j++)
        // {
        //     location = rn.nextInt(190 -170 + 1) + 170;
        //     rotation = rn.nextInt(360) + 1;
        //     solarObjects[j] = new SolarSystemObject(location, rotation, 2, "#A9A9A9"); //Asteroids
        // }

        // solarObjects[700] = new Planets(50, 0, 10, "#964b00", 1); //Mercury
        // solarObjects[701] = new Planets(90, 175, 8, "#8B8000", 2); //Venus
        // solarObjects[702] = new Planets(115, 125, 12, "#436380", 3); //Earth
        // solarObjects[703] = new Planets(150, 25, 12, "#BC2732", 4); //Mars
        // solarObjects[704] = new Planets(225, 150, 20, "#e36e4b", 5); //Jupiter
        // solarObjects[705] = new Planets(300, 50, 16, "#C2B280", 6); //Saturn
        // solarObjects[706] = new Planets(335, 100, 10, "#30D5C8", 7); //Uranus
        // solarObjects[707] = new Planets(350, 75, 12, "#00008b", 8); //Neptune

        // moons[0] = new Moons(13, 0, 5, "GREY", 3, 115, 125); //Earths Moon
        // moons[1] = new Moons(23, 45, 5, "GREY", 5, 225, 150); //Jupiter Moon 1
        // moons[2] = new Moons(23, 90, 5, "GREY", 5, 225, 150); //Jupiter Moon 2
        // moons[3] = new Moons(23, 165, 5, "GREY", 5, 225, 150); //Jupiter Moon 3
        // moons[4] = new Moons(23, 245, 5, "GREY", 5, 225, 150); //Jupiter Moon 4

        // for (int j = 5; j < moons.length; j++)
        // {
        //     location = rn.nextInt(25 -20 + 1) + 20;
        //     rotation = rn.nextInt(360) + 1;
        //     moons[j] = new Moons(20, rotation, 2, "#A9A9A9", 6, 300, 50); //Saturns ring
        // }
        
        while(true) //Loop to initiate the planets orbitting of the sun
        {
            for (int i = 0; i < adder; i++)
            {
                mW.drawSolarObject(solarObjects[i].getDistance(), solarObjects[i].getAngle(), solarObjects[i].getDiameter(), solarObjects[i].getColour());
                if (!(solarObjects[i].getName().equals("Star"))) //if its a star than don't move
                    solarObjects[i].move();
            }

            for (int i = 0; i < adderM; i++)
            {
                mW.drawSolarObjectAbout(moons[i].getDistance(), moons[i].getAngle(), moons[i].getDiameter(), moons[i].getColour(), moons[i].getCORD(), moons[i].getCORA());
                moons[i].move();
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

    @Override
    public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour) 
    {
        solarObjects[adder] = new Planets(name, orbitalDistance, initialAngle, size, colour, speed);
        adder++;
    }

    @Override
    public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour, String parentName) 
    {
        for (int i = 0; i < adder; i++)
        {
            if (solarObjects[i].getName().equals(parentName))
            {
                cord = solarObjects[i].getDistance();
                cora = solarObjects[i].getAngle();
                spd = solarObjects[i].getSpeed();
            }
        }
        moons[adderM] = new Moons(name, orbitalDistance, initialAngle, size, colour, spd, cord, cora);
        adderM++;
    }

    @Override
    public void remove(String name) 
    {
        remName = name; 
    }
}