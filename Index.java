package uebung3;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;

public class Index
{
    private final HashMap<String, ArrayList<Integer>> hashy;
    private final TreeMap<String, ArrayList<Integer>> groot;

    public Index()
    {
        hashy = new HashMap<String, ArrayList<Integer>>();
        groot = new TreeMap<String, ArrayList<Integer>>();
    }

    public void wortHinzufuegen(String wort, int seite)
    {
        if (!hashy.containsKey(wort))
        {
            ArrayList<Integer> pages = new ArrayList<Integer>();
            hashy.put(wort, pages);
        }
        ArrayList<Integer> pages = (ArrayList<Integer>) hashy.get(wort);
        if (!pages.contains(seite))
        {
            pages.add(seite);
        }
        Collections.sort(pages); // Anforderung Zusatzaufgabe

    }
    
    public void wortTHinzufuegen(String wort, int seite)
    {
        if (!groot.containsKey(wort))
        {
            ArrayList<Integer> gpages = new ArrayList<Integer>();
            groot.put(wort, gpages);
        }
        ArrayList<Integer> gpages = (ArrayList<Integer>) groot.get(wort);
        if (!gpages.contains(seite))
        {
            gpages.add(seite);
        }
        //Collections.sort(pages); // Anforderung Zusatzaufgabe

    }

    public ArrayList<Integer> getAlleFundstellen(String word)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (hashy.containsKey(word))
        {
            ret = (ArrayList<Integer>) hashy.get(word);
        }
        return new ArrayList<Integer>(ret);
    }

    public ArrayList<Integer> getAlleTFundstellen(String word)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (groot.containsKey(word))
        {
            ret = (ArrayList<Integer>) groot.get(word);
        }
        return new ArrayList<Integer>(ret);
    }
    
    public int getErsteFundstelle(String word)
    {
        int page = -1;
        if (hashy.containsKey(word))
        {
            ArrayList<Integer> pages = (ArrayList<Integer>) hashy.get(word);
            Collections.sort(pages);
            page = pages.get(0);
        }
        return page;
    }
    
    public int getErsteTFundstelle(String word)
    {
        int page = -1;
        if (groot.containsKey(word))
        {
            ArrayList<Integer> pages = (ArrayList<Integer>) groot.get(word);
            Collections.sort(pages);
            page = pages.get(0);
        }
        return page;
    }

    public String toString()
    {
        String ret = "";
        for (Entry<String, ArrayList<Integer>> entry : hashy.entrySet())
        {
            ret += String.format("%s: %s\n", entry.getKey(),
                    entry.getValue().toString());
        }
        return ret;
    }
    
    public String toTString()
    {
        String ret = "";
        for (Entry<String, ArrayList<Integer>> entry : groot.entrySet())
        {
            ret += String.format("%20s: %-30s\n", entry.getKey(),
                    entry.getValue().toString());
        }
        return ret;
    }
}
