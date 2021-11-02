package uebung4;

import java.util.Locale;

public class BenutzerFormat implements BruchFormat
{
    private final String bruchDarstellung;
    private final Locale userLocale;

    public BenutzerFormat(String stringf, Locale loc)
    {
        this.bruchDarstellung = stringf;
        this.userLocale = loc;
    }

    public BenutzerFormat(String stringf)
    {
        this.bruchDarstellung = stringf;
        this.userLocale = Locale.GERMAN;
    }

    @Override
    public String bruchToString(int z, int n)
    {
        double e = (double) z / n;
        return String.format(this.userLocale, this.bruchDarstellung, e);
    }
}
