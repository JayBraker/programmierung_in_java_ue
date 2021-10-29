package uebung2;

import java.io.*;
import java.util.Scanner;

import javax.swing.JFileChooser;

import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaCode
{
    private ArrayList<String> codeLines = new ArrayList<>();
    private static final String LINE_COMMENT = "//";
    private static final String BEG_BLOCK_COMMENT = "/*";
    private static final String BLOCK_COMMENT = "*";
    private static final String END_BLOCK_COMMENT = "*/";

    public void ladeCode(File f)
    {
        codeLines.clear();
        Scanner reader;
        try
        {
            reader = new Scanner(f);
            ladeCode(reader);
        } catch (FileNotFoundException e)
        {
            System.out.println("Datei " + f + " laesst sich nicht oeffnen!");
            System.exit(1);
        }
    }

    private void ladeCode(Scanner sc)
    {
        while (sc.hasNextLine())
        {
            codeLines.add(sc.nextLine());
        }
        sc.close();
    }

    public void ladeCode(URL url)
    {
        URLConnection con;
        Object content;
        try
        {
            con = url.openConnection();
            content = con.getContent();
            Scanner sc = new Scanner((InputStream) content);
            ladeCode(sc);
        } catch (IOException e)
        {
            System.out.println("Die URL " + url.getPath()
                    + " konnte nicht geoeffnet werden:");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void ladeCode() throws FileNotFoundException
    {
        File file = getFile();
        ladeCode(file);
    }

    public void schreibeCode(File f) throws FileNotFoundException
    {
        PrintWriter writer;
        writer = new PrintWriter(f);
        schreibeCode(writer);
    }

    private void schreibeCode(PrintWriter pw)
    {
        for (String line : codeLines)
        {
            pw.println(line);
        }
        pw.close();
    }

    public void schreibeCode() throws FileNotFoundException
    {
        File file = getFile();
        schreibeCode(file);
    }

    private File getFile() throws FileNotFoundException
    {
        File file = null;
        JFileChooser fc = new JFileChooser(
                new File(System.getProperty("user.dir")));
        int state = fc.showOpenDialog(null);
        if (state == JFileChooser.APPROVE_OPTION)
        {
            file = fc.getSelectedFile();
        } else
        {
            throw new FileNotFoundException("Auswahl abgebrochen");
        }
        return file;
    }

    public void entferneKommentare()
    {
        for (String line : codeLines)
        {
            if (line.contains(LINE_COMMENT))
            {
                String[] sp = line.split("//");
                System.out.println(sp.length);
            }
        }
    }

    public void printCode()
    {
        for (String line : codeLines)
        {
            System.out.println(line);
        }
    }

    public static void tests() throws FileNotFoundException
    {
        JavaCode handler = new JavaCode();
        File f = new File(
                "C:\\Users\\og415626\\eclipse-workspace\\Programmierung in Java\\src\\uebung2\\KommentarTest.java");
        File o = new File(f.getAbsolutePath().split("\\.")[0] + "_copy.java");
        System.out.println(o.getAbsolutePath());
        handler.ladeCode(f);
        handler.printCode();
        handler.schreibeCode(o);

        handler = new JavaCode();
        URL url;
        try
        {
            url = new URL(
                    "https://www.matse.itc.rwth-aachen.de/dienste/public/show_document.php?id=59769278");
            handler.ladeCode(url);
            o = new File("internetcode.java");
            handler.schreibeCode(o);
            System.out.println(o.getAbsolutePath());
        } catch (MalformedURLException e)
        {
            System.out.println("Ungültige URL!");
        }

        handler = new JavaCode();
        handler.ladeCode();
        handler.printCode();
        handler.schreibeCode();
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        JavaCode handler = new JavaCode();
        File f = new File(
                "C:\\Users\\og415626\\eclipse-workspace\\Programmierung in Java\\src\\uebung2\\KommentarTest.java");
        File o = new File(f.getAbsolutePath().split("\\.")[0] + "_copy.java");
        System.out.println(o.getAbsolutePath());
        handler.ladeCode(f);
        handler.entferneKommentare();
        handler.printCode();
        handler.schreibeCode(o);
    }
}
