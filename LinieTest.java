package uebung7;

import java.awt.Point;

public class LinieTest {
  public static void main(String[] args) {

    // neues Grafikfenster mit einer Zeichenflaeche der
    // angegebenen Breite und Hoehe oeffnen:
    Grafik g = new Grafik(300, 300);

    // eine Linie zeichnen, die vom angegebenen Startpunkt bis
    // zum angegebenen Endpunkt reicht:
    Point startpunkt = new Point(10, 10);
    Point endpunkt = new Point(200, 100);
    Linie l = new Linie(startpunkt, endpunkt);
    // => Der Koordinatenursprung liegt links oben!

    g.add(l); // die Linie in die Zeichenflaeche einfuegen
    g.aktualisiere(0); // die Zeichenflaeche sofort aktualisieren
  }
}
