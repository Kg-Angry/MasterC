// Uros Markovic RA53-2019
#include <stdio.h>
#include <math.h>

int main ()
{
	int n;
	int m;
	int i;
	int j;
	float a;
	int suma;
	int brojac = 0;
	
do{
	do{ printf("Unesite prirodan broj n:\n");
	    scanf ("%d", &n);
	    printf("Unesite prirodan broj m:\n");
	    scanf("%d", &m);
	} while (n<=0 || m<=0 );
}while (m<n);
	suma = 0;
	for (i=n; i<m; i++){ 
		for (j=n; j<=m; j++){
		suma+=i;
	}	
	/*	if (i=n+2) continue;
		if (i=n+3)  
		  if (suma>10) printf ("Trenutna vrednost sume je %.2f", suma)
			else ("Trenutna vrednost sume je %.1f, suma);
	*/
	brojac ++;	
}

printf("[i=%d] trenutna suma = %d \n", brojac, suma);
	
	 printf ("Unesite broj sa tastature:\n");
		scanf ("%.3f", &a);		
	float suma1 = 0;
 		if (a%2==0) suma1 = suma + pow(brojac*brojac,1/3)
 			else suma1 = suma - sqrt(pow(brojac, 3));
 			
 	if (suma1<a) printf ("ukupna suma je manja od broja %.3f", a)
 		else printf ("ukupna suma je veca od broja %.3f", a);
 		
return 0;
}
