package Model;

import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;

import Default.PolynomialRootFinder;

public class Polynomial {
	
	private static String date;
	private double coefficients[];
	private double b[];
	private double c[];
	private int grade;
	private Number[] numbers;
	
	
	public Polynomial(String date, int grade) {
		this.date = date;
		this.grade = grade;
		b = new double[20];
	    c = new double[20];
		numbers = new Number[11];
	}
	public String getDate() {
		return date;
	}
	public void startBairstow() {
		covertData();
		solveBairstow();
	}
	public void startRootFinder() {
		covertData();
		findRoots(coefficients);
	}
	
	public void covertData() {
		coefficients = new double[grade+1];
		String auxi[] = date.split(" ");
		//Hay que poner una exepción aqui
		for (int i = 0; i < auxi.length; i++) {
			numbers[i] = new Number(auxi[i]);
			coefficients[i] = numbers[i].getNumber();
		}
	}
	
	public void solveBairstow()
	  {
		date="";
		int i, j;
	    double r1, r2, du, dv, u, v, r, dr;
	    double sq, det, nu, nv, error;
	    double epsilon = 1e-8;
	    while (grade > 2) {
	      u = 0;
	      v = 0;
	      error = 1;
	      c[grade] = b[grade] = coefficients[grade];

	      while (error > epsilon) {
	        b[grade-1] = coefficients[grade-1] + u * b[grade];
	        c[grade-1] = b[grade-1] + u * c[grade];

	        for (i = grade - 2; i > 0; i--) {
	          b[i] = coefficients[i] + u * b[i+1] + v * b[i+2];
	          c[i] = b[i] + u * c[i+1] + v * c[i+2];
	        }

	        b[0] = coefficients[0] + u * b[1] + v * b[2];

	        det = (c[2] * c[2]) - c[1] * c[3];

	        nu = b[0] * c[3] - b[1] * c[2];
	        nv = b[1] * c[1] - b[0] * c[2];
	        
	        if (det == 0) {
	          du = dv = 1;
	        } else {
	          du = nu / det;
	          dv = nv / det;
	        }
	        
	        u += du;
	        v += dv;

	        error = Math.sqrt(du * du + dv * dv);
	      }
	      for(int t=grade-2;t>=0;t--){ 
	        date += "";
	      }
	      sq = u * u + 4 * v;

	      if (sq < 0) {
	        r1 = u/2;
	        r2 = Math.sqrt(-sq)/2;
	        date += r1 + " + " + r2 + "i\n"+r1 + " - " + r2 + "i\n";
	      } else {
	        r1 = u/2 + Math.sqrt(sq)/2;
	        r2 = u/2 - Math.sqrt(sq)/2;
	        date += r1 +"\n"+r2+"\n";
	      }

	      grade -= 2;

	      for (i = 0; i < grade + 1; i++)
	        coefficients[i] = b[i+2];
	    }
	    
//	    if (grade == 3) {
//	      r = 0;
//	      error = 1;
//	      b[grade] = coefficients[grade];
//
//	      while (error > epsilon) {
//	        b[2] = coefficients[2] + r * b[3];
//	        b[1] = coefficients[1] + r * b[2];
//	        b[0] = coefficients[0] + r * b[1];
//
//	        double d = coefficients[1] + (2 * coefficients[2] * r) + (3 * coefficients[3] * r * r);
//
//	        if (d == 0)
//	          dr = 1;
//	        else
//	          dr = -b[0] / d;
//
//	        r -= dr;
//	        error = Math.abs(dr);
//	      }
//
//	      date +=r +"\n";
//	      grade--;
//
//	      for (i = 0; i < grade + 1; i++)
//	        coefficients[i] = b[i + 1];
//	    }


	    if (grade == 2) {
	      u = -coefficients[1] / coefficients[2];
	      v = -coefficients[0] / coefficients[2];
	      sq = u * u + 4 * v;

	      if (sq < 0) {
	        r1 = u/2;
	        r2 = Math.sqrt(-sq)/2;
	        date += r1 + " + " + r2 + "i\n"+r1 + " - " + r2 + "i\n";
	      } else {
	        r1 = u/2 + Math.sqrt(sq)/2;
	        r2 = u/2 - Math.sqrt(sq)/2;
	        date += r1 +"\n"+r2+"\n";
	      }
	    } else if (grade == 1) {
	      date += -coefficients[0] / coefficients[1]+"\n";
	    }
	  }
	
	
    
    public static Complex_F64[] findRoots(double... coefficients) {
        int N = coefficients.length-1;
        DMatrixRMaj c = new DMatrixRMaj(N,N);

        double a = coefficients[N];
        for( int i = 0; i < N; i++ ) {
            c.set(i,N-1,-coefficients[i]/a);
        }
        for( int i = 1; i < N; i++ ) {
            c.set(i,i-1,1);
        }
        EigenDecomposition_F64<DMatrixRMaj> evd =  DecompositionFactory_DDRM.eig(N,false);

        evd.decompose(c);

        Complex_F64[] roots = new Complex_F64[N];
        date="";
        for( int i = 0; i < N; i++ ) {
            roots[i] = evd.getEigenvalue(i);
            date += roots[i] +"\n";
        }

        return roots;
    }
	
}
