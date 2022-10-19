public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /* Creates a LinearEquation object */
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
       the nearest hundredth using pythagorean theorem */
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2)));
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth by substituting x1 and y1 into the slope formula */
    public double yIntercept() {
        return roundedToHundredth(-slope() * x1 + y1);
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth by calculating change in y divided by change in x */
    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form */
    public String equation() {
        int rise = y2 - y1;
        int run = x2 - x1;

        if (rise == 0) { // horizontal slope
            return "y = " + y1;
        }
        else if (run < 0) { // move the negative sign to other integer if it is in denominator OR remove negative sign if both integers have it
            rise *= -1;
            run *= -1;
        }

        String slope = rise % run == 0 // check if it can be simplified into an integer
                ? (Math.abs(rise / run) != 1 // true: check if slope is not 1 or -1
                    ? "" + rise / run // true: return simplified slope
                    : rise / run < 0 ? "-" : "") // false: return "-" if slope is -1
                : rise + "/" + run; // false: return "rise/run" without simplifying

        String yIntercept = yIntercept() != 0 // check if there is a y-intercept
                ? yIntercept() > 0 // true: check if y intercept is + or -
                    ? " + " + Math.abs(yIntercept()) // (+) return add y-intercept
                    : " - " + Math.abs(yIntercept()) // (-) return minus y-intercept
                : ""; // false: return empty string

        return "y = " + slope + "x" + yIntercept;
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue) {
        return "(" + xValue + ", " + roundedToHundredth(slope() * xValue + yIntercept()) + ")";
    }

    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth */
    public double roundedToHundredth(double toRound) {
        return (double) Math.round(toRound * 100) / 100; // use casting to round to the nearest hundredth
    }

    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method) */
    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")"
                + "\nThe equation of this line between these points is: " + equation()
                + "\nThe slope of this line is: " + slope()
                + "\nThe y-intercept of this line is: " + yIntercept()
                + "\nThe distance between the two points is: " + distance();
    }
}