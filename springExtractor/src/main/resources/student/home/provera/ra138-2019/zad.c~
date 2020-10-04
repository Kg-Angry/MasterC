// Rade Stojanovic RA138-2019

#include <stdio.h>
#include <math.h>

int main(){
	int n, m, i;
	double a;
	double suma = 0;
	
	printf("Opseg: \n\n");
	do{
		printf("     n = ");
		scanf("%d", &n);
	}while(n<=0);
	
	do{
		printf("     m = ");
		scanf("%d", &m);
	}while(m<=n);
	
	for(i=n; i<=m; i++){
		if(i==n+2){
			continue;
		}
		if(i%2==0){
			suma += pow(i*i*1.0, 1.0/3);
		}else{
			suma -= sqrt(i*i*i*1.0);
		}
		if(i==n+3){
			if(suma>10.0){
				printf("\n[i=%d] trenutna suma: %0.2lf\n", i, suma);
			}else{
				printf("\n[i=%d] trenutna vrednost sume: %0.1lf\n", i, suma);
			}
		}
	}
	printf("\n\nuneti broj: ");
	scanf("%lf", &a);
	
	if(a < suma){
		printf("\n     ukupna suma je veca od broja %0.3lf\n\n", a);
	}else if(a == suma){
		printf("\n     ukupna suma je jednaka broju %0.3lf\n\n", a);
	}else if(a > suma){
		printf("\n     ukupna suma je manja od broja %0.3lf\n\n", a);
	}
	
	return 0;
}






