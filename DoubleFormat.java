package uebung4;

public class DoubleFormat implements BruchFormat
{
    @Override
    public String bruchToString(int z, int n)
    {
        return String.valueOf((double) z / n);
    }
}
