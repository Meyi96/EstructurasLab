Proceso computeRoot
	EPSILON <- 0.0001
	INITIAL_GUESS <- 0.1
	MAX_ITERATIONS <- 100
	tamanio  <- 10
	DIMENSION poly[10] 
	val = newtonsMethod(poly por referencia, INITIAL_GUESS, 0)
FinProceso

SubProceso poly<- computeDerivate(poly Por Referencia)
	si (tamanio>1)entonces
		para i=0 hasta tamanio
			poly[i] = poly[i]*i-1
		FinPara
	Sino
		poly[0] = 0
	FinSi
	
FinSubProceso

SubProceso val <- evaluale(poly por referencia, x)
	si (poly > tamanio) Entonces
		resultado = 0
		Collections.reverse(poly)
		Para i=0 hasta tamanio
			result = result + poly[i]*Math.pow(x, tamanio-i-1) 
			val =result
		FinPara
	Sino
		val = poly[0]+x
	FinSi
	
FinSubProceso

SubProceso val<- newtonsMethod(poly por referencia, x0, iter)
	x1 = x0
	retorno =0
	fx = evaluale(poly, x0)
	definir list Como Entero
	Dimension list[10]
	mostrar x1
	si (iter = MAX_ITERATIONS || Math.abs(x0-x1)<= EPSILON) ENTONCES
		retorno = x1
	Sino
		retorno = newtonMethod(list, 1 iter)
	FinSi
	
FinSubProceso
