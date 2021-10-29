package uebung3;

import java.util.ArrayList;

public class Test
{
    public static void main(String[] args)
    {
        Index index = new Index();
        index.wortHinzufuegen("boolean", 1);
        index.wortHinzufuegen("boolean", 15);
        index.wortHinzufuegen("boolean", 3);
        index.wortHinzufuegen("boolean", 15);
        index.wortHinzufuegen("if", 45);
        index.wortHinzufuegen("if", 2);
        index.wortHinzufuegen("if", 10);
        index.wortHinzufuegen("if", 45);
        System.out.println(("index"));
        System.out.println(index);

        ArrayList<Integer> seiten = index.getAlleFundstellen("boolean");
        System.out.println("seiten = " + seiten);
        int ersteStelle = index.getErsteFundstelle("if");
        System.out.println("ersteStelle = " + ersteStelle);
    }
}
