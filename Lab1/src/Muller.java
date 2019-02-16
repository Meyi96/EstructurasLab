
import java.text.*;

/* This is a Java implementation of Muller's algorithm for root finding,
   which was given in Chapter 1 of your Numerical Analysis textbook.
   Author: Martha Kosa */

class Muller{
   static double doFunction(double x) {
      return 3 * x + x*x*x*2 - x*x*6;
   }

   static void doMuller(double x2, double x0, double x1) {

      int iterNum = 1;    /* how many times algorithm has been performed */
      double f0, f1, f2, fr;  /* function values */
      double a, b, c;     /* quadratic coefficients */
      double h1, h2, gamma, gammaplus; /* used in computing quadratic
                                          coefficients */
      double disc;        /* discriminant of quadratic */
      double r1, r2;      /* roots of quadratic */
      double xr;          /* closest root to x0 */
      /* to print numbers with 8 digits behind the decimal point */
      DecimalFormat df = new DecimalFormat("0.00000000");
      double tolerance = 0.0000001;   /* indicates smallest possible interval
                                        width to search */
      int maxIterations = 50;  /* the maximum number of times to do
                                  the bisection */

      System.out.println("Iteration #\tX0\t\tX1\t\tX2\t\tF(X2)"); // \t is a tab

      do {
	 f2 = doFunction(x2);
	 f0 = doFunction(x0);
	 f1 = doFunction(x1);

	 System.out.println(iterNum + "\t\t" + df.format(x0) + "\t" +
	                    df.format(x1) + "\t" + df.format(x2) + "\t" +
			    df.format(f2));

	 h1 = x1 - x0;
	 h2 = x0 - x2;
	 c = f0;
	 gamma = h2/h1;
	 gammaplus = gamma + 1;
	 a = (gamma * f1 - f0 * gammaplus + f2) / (gamma * h1 * h1 * gammaplus); 
	 b = (f1 - f0 - a * h1 * h1) / h1;
	 disc = Math.sqrt(b * b - 4 * a * c);
	 r1 = x0 - 2 * c / (b + disc);
	 r2 = x0 - 2 * c / (b - disc);

         if (Math.abs(r1 - x0) < Math.abs(r2 - x0)) {
	    xr = r1;
         }
	 else {
	    xr = r2;
	 }

	 if (xr > x0) {
	    x2 = x0;
	    x0 = xr;
	 }
	 else {
	    x1 = x0;
	    x0 = xr;
	 }
         iterNum++;          // current iteration has been completed
	 fr = doFunction(xr);
      } while (Math.abs(fr) >= tolerance && iterNum <= maxIterations);
      /* we haven't found a root and it's not time to give up yet */
   }         

   public static void main(String[] args) {
      doMuller(0, 0.5, 1);
   }
}
