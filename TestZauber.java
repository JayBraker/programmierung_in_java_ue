package uebung3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestZauber
{
    public static void main(String[] args)
    {
        try
        {
            treemapTest();
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void hashmapTest() throws FileNotFoundException {
        Index index = new Index();
        File f = new File("C:\\Users\\og415626\\eclipse-workspace\\Programmierung in Java\\src\\uebung3\\zauberlehrling.txt");
        Scanner sc = null;
        sc = new Scanner(f);
        
        int lineCount = 0;
        while(sc.hasNextLine()) {
            lineCount++;
            String[] line = sc.nextLine().split(" ");
            
            for (String word : line) {
                if (word.length() > 3 && (Character.isUpperCase(word.charAt(0)))) {
                    index.wortHinzufuegen(word, lineCount);
                    System.out.printf("%s: %d\n", word, lineCount);
                }
            }
        }
    }

    public static void treemapTest() throws FileNotFoundException
    {
        Index index = new Index();
        File f = new File(
                "C:\\Users\\og415626\\eclipse-workspace\\Programmierung in Java\\src\\uebung3\\zauberlehrling.txt");
        Scanner sc = null;
        sc = new Scanner(f);

        int lineCount = 0;
        while (sc.hasNextLine())
        {
            lineCount++;
            String[] line = sc.nextLine().split(" ");

            for (String word : line)
            {
                if (!word.isBlank())
                {
                    if ((word.charAt(0) > 64 && word.charAt(0) < 91)
                            && word.length() > 3)
                    {
                        index.wortTHinzufuegen(word, lineCount);
                        // System.out.printf("%s: %d\n", word, lineCount);
                    }
                }
            }
        }
        System.out.println(index.toTString());
    }
}
