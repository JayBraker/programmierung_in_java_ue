package uebung4;

public class SchraegStrichFormat implements BruchFormat
{
    @Override
    public String bruchToString(int z, int n)
    {
        return String.format("%d/%d", z, n);
    }
}
