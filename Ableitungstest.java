package uebung8;

import java.util.Locale;

public class Ableitungstest {

  public static void main(String[] args) {
    Funktion f1 = new AXhochN(3, 2);   // Fassung mit Konstruktoren, die
    Funktion f2 = new AXhochN(7, 1);   // noch nicht `private' sind
    Funktion f  = new Summe(f1, f2);
    // Wenn die statische Methode `get' implementiert wurde,
    // muessen diese drei Zeilen ein- und die oberen drei
    // auskommentiert werden:
    /*
    Funktion f1 = AXhochN.get(3, 2);   // schon voll optimierte Fassung
    Funktion f2 = AXhochN.get(7, 1);
    Funktion f  = Summe.get(f1, f2);
    */
    test(f, 2);

  }

  // die Ableitungen f, f', f'', f''' der gegebenen reellen Funktion f
  // bestimmen, jede Ableitung bei x auswerten und alles ausgeben
  public static void test(Funktion f, double x) {
    for (int i = 0; i < 4; i++) {
      System.out.println(i + ". Ableitung: " + f);
      System.out.printf(Locale.US, "f(%1.0f) = %-4.1f\n", x, f.getY(x));
      f = f.getAbleitung();
    }
    System.out.println("==============");
  }
}

