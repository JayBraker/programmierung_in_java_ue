package uebung8;

public class Null implements Funktion {

  @Override
  public double getY(double d) {
    return 0;
  }

  @Override
  public Funktion getAbleitung() {
    return new Null();
  }
}
