public class Body {
    public double xxPos; //current x position
    public double yyPos; //current y position
    public double xxVel; // current velocity in the x direction
    public double yyVel;
    public double mass;
    public String imgFileName; //the name of the file that corresponds to the image that depicts the body

    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        if (b == this) return 0;
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Body b) {
        if (b == this) return 0;
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        double F = 6.67 * Math.pow(10, -11) * this.mass * b.mass / (r * r);
        return F;
    }

    public double calcForceExertedByX(Body b) {
        if (b == this) return 0;
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        double F = 6.67 * Math.pow(10, -11) * this.mass * b.mass / (r * r);
        double Fx = F * dx / r;
        return Fx;
    }

    public double calcForceExertedByY(Body b) {
        if (b == this) return 0;
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        double F = 6.67 * Math.pow(10, -11) * this.mass * b.mass / (r * r);
        double Fy = F * dy / r;
        return Fy;
    }

    public double calcNetForceExertedByX(Body[] bs) {
        double allForce = 0;
        for (Body b : bs) {
            allForce += calcForceExertedByX(b);
        }
        return allForce;
    }

    public double calcNetForceExertedByY(Body[] bs) {
        double allForce = 0;
        for (Body b : bs) {
            allForce += calcForceExertedByY(b);
        }
        return allForce;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
