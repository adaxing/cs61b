public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;

    /** constructor 1 */
    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    /** constructor 2 */
    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b) {
        double xP = b.xxPos;
        double yP = b.yyPos;
        return Math.sqrt((xxPos - xP)*(xxPos - xP) + (yyPos - yP)*(yyPos - yP));
    }
    public double calcForceExertedBy(Body b) {
        double r = calcDistance(b);
        double m = b.mass;
        return (G*m*mass)/ (r*r);
    }
    public double calcForceExertedByX(Body b) {
        double xP = b.xxPos;
        double r = calcDistance(b);
        double F = calcForceExertedBy(b);
        return (F*(xP - xxPos)) / r ;
    }
    public double calcForceExertedByY(Body b) {
        double yP = b.yyPos;
        double r = calcDistance(b);
        double F = calcForceExertedBy(b);
        return (F*(yP - yyPos)) / r ;
    }
    public double calcNetForceExertedByX(Body[] allBodys) {
        double netF = 0.0;
        for (Body b: allBodys) {
            if (this.equals(b)) {
                continue;
            } else {
                double xF = calcForceExertedByX(b);
                netF += xF;
            }
        }
        return netF;
    }
    public double calcNetForceExertedByY(Body[] allBodys) {
        double netF = 0.0;
        for (Body b: allBodys) {
            if (this.equals(b)) {
                continue;
            } else {
                double yF = calcForceExertedByY(b);
                netF += yF;
            }
        }
        return netF;
    }
    public void update(double dt, double xF, double yF) {
        /** new acceleration */
        double xAcc = xF / mass;
        double yAcc = yF / mass;
        /** new velocity */
        xxVel += (dt * xAcc);
        yyVel += (dt * yAcc);
        /** new position */
        xxPos += (dt * xxVel);
        yyPos += (dt * yyVel);
    }

}