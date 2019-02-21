package Default;

import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;

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