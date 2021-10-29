package uebung4;

public class SchraegStrichFormat implements Bruch.BruchFormat
{
    @Override
    public String bruchToString(int z, int n)
    {
        return String.format("%d/%d", z, n);
    }
}
