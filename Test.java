package uebung4;

import java.util.Locale;

public class Test
{
    public static void main(String[] args)
    {
        Bruch bruch1 = new Bruch(23, 3);

        bruch1.setBruchdarstellung(new DoubleFormat());
        System.out.println(bruch1 + "\n");

        bruch1.setBruchdarstellung(new SchraegStrichFormat());
        System.out.println(bruch1 + "\n");

        bruch1.setBruchdarstellung(new BenutzerFormat("%.2f"));
        System.out.println(bruch1 + "\n");

        bruch1.setBruchdarstellung(new BenutzerFormat("%.3f", Locale.US));
        System.out.println(bruch1 + "\n");

        bruch1.setBruchdarstellung(new DreiZeilenFormat());
        System.out.println(bruch1 + "\n");
    }
}
