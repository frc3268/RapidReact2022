package frc.robot;

public class ProjectileMotion {
  public static class FindDistance {
    private double angle;
    private double initVelocity;

    public FindDistance(double angle, double initVelocity) {
      this.angle = angle;
      this.initVelocity = initVelocity;
    }

    public static double findDistance(double angle, double initVelocity) {
      double d = (initVelocity * initVelocity) * Math.sin(2 * angle) / 9.81;
      System.out.println(d);
      return d;
    }
  }

  public static class FindAngle {
    private double initVelocity;
    private double distance;

    public FindAngle(double distance, double initVelocity) {
      this.distance = distance;
      this.initVelocity = initVelocity;
    }

    public static double findAngle(double distance, double initVelocity) {
      double a1 = (1 / 2) * Math.asin(9.81 * distance / (initVelocity * initVelocity));
      double a2 = (1 / 2) * Math.acos(9.81 * distance / (initVelocity * initVelocity));
      System.out.println(a1);
      System.out.println(a2);
      return a1;
    }
  }

  public static class FindVelocity {
    private double angle;
    private double distance;

    public FindVelocity(double angle, double distance) {
      this.angle = angle;
      this.distance = distance;
    }

    public static double findVelocity(double angle, double distance) {
      double v = Math.sqrt(9.81 * distance / Math.sin(2 * angle));
      System.out.println(v);
      return v;
    }
  }

  public static void main(String[] args) {
    double distance = FindDistance.findDistance(Math.PI / 4, 40);
    double angle = FindAngle.findAngle(600, 80);
    double velocity = FindVelocity.findVelocity(Math.PI / 4, 16093.4);

  }
}