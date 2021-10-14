public class Sun
{
    public static void main(String[] args)
    {
        SolarSystem mW = new SolarSystem(500, 500);
        mW.drawSolarObject(0, 0, 60, "YELLOW");
        mW.drawSolarObject(100, 20, 10, "BLUE");
    }
}