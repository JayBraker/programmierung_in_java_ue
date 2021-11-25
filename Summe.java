package uebung8;

public class Summe implements Funktion {

  private final Funktion F1;
  private final Funktion F2;

  public Summe(Funktion f1, Funktion f2) {
    F1 = f1;
    F2 = f2;
  }

  @Override
  public double getY(double d) {
    return F1.getY(d) + F2.getY(d);
  }

  @Override
  public Funktion getAbleitung() {
    return new Summe(F1.getAbleitung(), F2.getAbleitung());
  }
}
