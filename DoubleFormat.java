package uebung4;

public class DoubleFormat implements Bruch.BruchFormat
{
    @Override
    public String bruchToString(int z, int n)
    {
        return String.valueOf((double) z / n);
    }
}
