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

SubProceso checkRoot(root, coefs)
	total = 0
	a = 1
	Para c =0 hasta coefs
		total = total+(a*c)
		a= a*root
	FinPara
FinSubProceso

SubProceso Complex_F64[] <- findRootss(coefficients por referencia)
	N = coefficients.length-1
	definir roots como Complex_F64[]
	numReal = 0
	para Complex_F64 hasta root
		si (c.isReal())
			checkRoot(c.real,4,3,2,1)
			numReal = numReal+1
		FinSi
	FinPara
FinSubProceso
