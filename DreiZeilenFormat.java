package uebung4;

import java.util.Arrays;

public class DreiZeilenFormat implements Bruch.BruchFormat
{
    @Override
    public String bruchToString(int z, int n)
    {
        int longest_num = String.valueOf(z).length();
        if (longest_num < String.valueOf(n).length())
        {
            longest_num = String.valueOf(n).length();
        }

        StringBuilder build = new StringBuilder();
        build.append("%" + longest_num + "d\n");
        char[] underscore = new char[longest_num];
        Arrays.fill(underscore, '-');
        build.append(new String(underscore));
        build.append("\n%" + longest_num + "d");

        return String.format(build.toString(), z, n);
    }
}
