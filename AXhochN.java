package uebung8;

public class AXhochN implements Funktion {

  private final double A;
  private final double N;

  public AXhochN(double a, double n) {
    A = a;
    N = n;
  }

  @Override
  public double getY(double d) {
    return A * Math.pow(d, N);
  }

  @Override
  public Funktion getAbleitung() {
    return new AXhochN(A * N, N - 1);
  }
}
