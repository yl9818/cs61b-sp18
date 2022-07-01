public class NBody {

    public static double readRadius(String file) {
        In in = new In(file);
        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String file) {
        In in = new In(file);
        int numberOfPlanets = in.readInt();
        Body[] result = new Body[numberOfPlanets];
        double radius = in.readDouble();
        for (int i = 0; i < numberOfPlanets; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String name = in.readString();
            result[i] = new Body(xPos, yPos, xVel, yVel, mass, name);
        }
        return result;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Body b : bodies) {
            b.draw();
        }
//        StdDraw.show();

        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time < T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for (int i = 0; i < bodies.length; i++) {
                double fX = bodies[i].calcNetForceExertedByX(bodies);
                double fY = bodies[i].calcNetForceExertedByY(bodies);
                xForces[i] = fX;
                yForces[i] = fY;
            }
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body bo : bodies) {
                bo.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }

    }
}
