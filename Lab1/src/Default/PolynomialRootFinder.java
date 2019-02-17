package Default;

import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DenseD2Matrix64F;
import org.ejml.dense.row.factory.DecompositionFactory_CDRM;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_ZDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;
import org.ejml.sparse.csc.factory.DecompositionFactory_DSCC;

public class PolynomialRootFinder {

    /**
     * <p>
     * Given a set of polynomial coefficients, compute the roots of the polynomial.  Depending on
     * the polynomial being considered the roots may contain complex number.  When complex numbers are
     * present they will come in pairs of complex conjugates.
     * </p>
     *
     * @param coefficients Coefficients of the polynomial.
     * @return The roots of the polynomial
     */
    public static Complex_F64[] findRootss(double[] coefficients) {
        int N = coefficients.length-1;

        Complex_F64[] roots = PolynomialRootFinder.findRoots(coefficients);

        int numReal = 0;
        for( Complex_F64 c : roots ) {
            if( c.isReal() ) {
                checkRoot(c.real,4,3,2,1);
                numReal++;
            }
        }
        return roots;
    }
    private static void checkRoot( double root , double ...coefs ) {
        double total = 0;
        double a = 1;
        for( double c : coefs ) {
            total += a*c;
            a *= root;
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

        for( int i = 0; i < N; i++ ) {
            roots[i] = evd.getEigenvalue(i);
            System.out.println(roots[i]);
        }

        return roots;
    }
    
    public static void main(String args[]) {
    	double lol[] = {12,7,1};
    	findRoots(lol);
    }
}