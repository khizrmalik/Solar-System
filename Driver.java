import java.util.Random;

public class Driver
{
    public static void main(String[] args)
    {
        Random rn = new Random();
        SolarSystem mW = new SolarSystem(800, 800); //creating a window for the solar system
        SolarSystemObject sun = new SolarSystemObject(0, 0, 60, "YELLOW");
        SolarSystemObject sun2 = new SolarSystemObject(0, 0, 50, "#FFE484");
        SolarSystemObject sun3 = new SolarSystemObject(0, 0, 40, "#FFCC33");
        SolarSystemObject sun4 = new SolarSystemObject(0, 0, 30, "#FFC000");
        SolarSystemObject sun5 = new SolarSystemObject(0, 0, 20, "#FC9601");
        SolarSystemObject sun6 = new SolarSystemObject(0, 0, 10, "#FFC000");


        SolarSystemObject[] asteroids = new SolarSystemObject[200];

        for (int j = 0; j < asteroids.length; j++)
        {
            int location = rn.nextInt(190 -170 + 1) + 170;
            int rotation = rn.nextInt(360) + 1;
            asteroids[j] = new SolarSystemObject(location, rotation, 2, "#A9A9A9");
        }

        SolarSystemObject[] stars = new SolarSystemObject[500];

        for (int j = 0; j < stars.length; j++)
        {
            int location = rn.nextInt(750) + 1;
            int rotation = rn.nextInt(360) + 1;
            stars[j] = new SolarSystemObject(location, rotation, 2, "WHITE");
        }

        SolarSystemObject[] planets = new Planets[8];
        planets[0] = new Planets(50, 0, 10, "#964b00", 1); //Mercury
        planets[1] = new Planets(90, 175, 8, "#8B8000", 2); //Venus
        planets[2] = new Planets(115, 125, 12, "#436380", 3); //Earth
        planets[3] = new Planets(150, 25, 12, "#BC2732", 4); //Mars
        planets[4] = new Planets(225, 150, 20, "#e36e4b", 5); //Jupiter
        planets[5] = new Planets(300, 50, 16, "#C2B280", 6); //Saturn
        planets[6] = new Planets(335, 100, 10, "#30D5C8", 7); //Uranus
        planets[7] = new Planets(350, 75, 12, "#00008b", 8); //Neptune

        Planets[] moons = new Moons[100];
        moons[0] = new Moons(13, 0, 5, "GREY", 3, 115, 125); //Earths Moon
        moons[1] = new Moons(23, 45, 5, "GREY", 5, 225, 150); //Jupiter Moon 1
        moons[2] = new Moons(23, 90, 5, "GREY", 5, 225, 150); //Jupiter Moon 2
        moons[3] = new Moons(23, 165, 5, "GREY", 5, 225, 150); //Jupiter Moon 3
        moons[4] = new Moons(23, 245, 5, "GREY", 5, 225, 150); //Jupiter Moon 4

        for (int j = 5; j < moons.length; j++)
        {
            int location = rn.nextInt(25 -20 + 1) + 20;
            int rotation = rn.nextInt(360) + 1;
            moons[j] = new Moons(20, rotation, 2, "#A9A9A9", 6, 300, 50);
        }


        
        while(true) //Loop to initiate the planets orbitting of the sun
        {
            for (int i = 0; i < stars.length; i++)
            {
                mW.drawSolarObject(stars[i].getDistance(), stars[i].getAngle(), stars[i].getDiameter(), stars[i].getColour());
            }

            mW.drawSolarObject(sun.getDistance(), sun.getAngle(), sun.getDiameter(), sun.getColour());
            mW.drawSolarObject(sun2.getDistance(), sun2.getAngle(), sun2.getDiameter(), sun2.getColour());
            mW.drawSolarObject(sun3.getDistance(), sun3.getAngle(), sun3.getDiameter(), sun3.getColour());
            mW.drawSolarObject(sun4.getDistance(), sun4.getAngle(), sun4.getDiameter(), sun4.getColour());
            mW.drawSolarObject(sun5.getDistance(), sun5.getAngle(), sun5.getDiameter(), sun5.getColour());
            //Sun created at the centre of the solar system

            for (int i = 0; i < planets.length; i++)
            {
                mW.drawSolarObject(planets[i].getDistance(), planets[i].getAngle(), planets[i].getDiameter(), planets[i].getColour());
                planets[i].move();
            }

            for (int i = 0; i < asteroids.length; i++)
            {
                mW.drawSolarObject(asteroids[i].getDistance(), asteroids[i].getAngle(), asteroids[i].getDiameter(), asteroids[i].getColour());
                asteroids[i].move();
            }

            for (int i = 0; i < moons.length; i++)
            {
                mW.drawSolarObjectAbout(moons[i].getDistance(), moons[i].getAngle(), moons[i].getDiameter(), moons[i].getColour(), moons[i].getCORD(), moons[i].getCORA());
                moons[i].move(); //Moon created to orbit the earth
            }

            mW.finishedDrawing(); //To refresh the display every increment
        }
    }
}
