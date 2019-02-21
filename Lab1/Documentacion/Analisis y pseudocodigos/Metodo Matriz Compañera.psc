Proceso PolynomialRootFinder
	definir coefficients Como Real
	findRoots(coefficients)
	
FinProceso

SubProceso Complex_F64[] <- findRoots(coefficients por referencia)
	N = coefficients.length-1
	Definir c como DMatrixRMaj(N,N)
	a = coefficients[N]
	para i=0 hasta N
		c.set(i,N-1,-coefficients[i]/a)
	FinPara
	para i=1 hasta N
		c.set(i,i-1,1)
	FinPara
	definir evd como EigenDecomposition_F64<DMatrixRMaj>
	evd.decompose(c)
	definir roots Complex_F64[N]
	para i=0 hasta N
		roots[i] = evd.getEigenvalue(i)
	FinPara
FinSubProceso


