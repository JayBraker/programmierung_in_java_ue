package uebung8;

import java.util.Locale;

public class AXhochN implements Funktion {

  private final double A;
  private final double N;

  private AXhochN(double a, double n) {
    A = a;
    N = n;
  }

  public static Funktion get(double a, double n) {
    if (a != 0) {
      return new AXhochN(a, n);
    } else {
      return null;
    }
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
    StringBuilder sb = new StringBuilder();
    String ret;
    if (A != 1) {
      sb.append(String.format(Locale.US, "%.1f", A));
    }
    sb.append("x");
    if (N != 1) {
      sb.append(String.format(Locale.US, "^%.1f", N));
    }

    if (A != 0) {
      ret = sb.toString();
    } else {
      ret = null;
    }
    return ret;
  }
}
