Proceso Bairstow
	dimension a[20]
	dimension b[20]
	dimension c[20]
	definir n como entero 
	solve()
FinProceso

SubProceso readInput()
	definir reader como BufferedReader
	n = Integer.parseInt(reader.readLine())
	tokens = reader.readLine().split(" ")
	para i=0 hasta n+1
		a[n-1]= Double.parseDouble(tokens[i])
	FinPara
FinSubProceso

SubProceso solve()
	definir i, j Como Entero
	definir r1, r2, du, dv, u, v, r, dr Como Real
	definir sq, det, nu, nv, error Como Real
	epsilon = 1e -8
	Mientras n>3 Hacer
		u =0
		v =0
		error =1
		c[n]= b[n] = a[n]
		Mientras error>epsilon Hacer
			b[n-1] = a[n-1] + u * b[n]
			c[n-1] = b[n-1] + u * c[n]
			para i=n hasta i>0
				b[i] = a[i] + u * b[i+1] + v * b[i+2]
				c[i] = b[i] + u * c[i+1] + v * c[i+2]
			FinPara
			b[0] = a[0] + u * b[1] + v * b[2]
			det = (c[2] * c[2]) - c[1] * c[3]
			nu = b[0] * c[3] - b[1] * c[2]
			nv = b[1] * c[1] - b[0] * c[2]
			si(det = 0)Entonces
				du = dv =1
			Sino
				du = nu / det
				dv = nv / det
			FinSi
			u =u+ du
			v = v+dv
			error = Math.sqrt(du * du + dv * dv)
		FinMientras
		sq = u * u + 4 * v
		si(sq<0)Entonces
			r1 = u/2
			r2 = Math.sqrt(-sq)/2
		Sino
			r1 = u/2 + Math.sqrt(sq)/2
			r2 = u/2 - Math.sqrt(sq)/2
		FinSi
		n -= 2
		para i=0 hasta n+1
			a[i] = b[i+2]
		FinPara
		si(n=3)Entonces
			r = 0
			error = 1
			b[n] = a[n]
			Mientras error>epsilon Hacer
				b[2] = a[2] + r * b[3]
				b[1] = a[1] + r * b[2]
				b[0] = a[0] + r * b[1]
				double d = a[1] + (2 * a[2] * r) + (3 * a[3] * r * r)
				si(d=0)Entonces
					dr=1
				Sino
					dr = -b[0] / d
					r -= dr
					error = Math.abs(dr)
				FinSi
			FinMientras
			n = n-1
			Para i=0 hasta n+1
				a[i] = b[i + 1]
			FinPara
		FinSi
		si(n=2)Entonces
			u = -a[1] / a[2]
			v = -a[0] / a[2]
			sq = u * u + 4 * v
			si(sq<0)Entonces
				r1 = u/2
				r2 = Math.sqrt(-sq)/2
			Sino
				r1 = u/2 + Math.sqrt(sq)/2
				r2 = u/2 - Math.sqrt(sq)/2
			FinSi
		Sino
			mostrar -a[0] / a[1]
		FinSi
	Fin Mientras
FinSubProceso
