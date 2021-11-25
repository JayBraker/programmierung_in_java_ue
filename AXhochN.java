package uebung8;

import java.util.Locale;

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

  @Override
  public String toString() {
    return String.format(Locale.US, "%.1f*x^%.1f", A, N);
  }
}
