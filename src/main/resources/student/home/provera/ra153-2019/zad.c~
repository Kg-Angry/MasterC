// Bogdan Davinic RA153-2019
#include <stdio.h>
#include <math.h>
int main(){
	//promenljive
	int n;
	int m;
	int i;
	double suma=0.0;
	double broj;
	
	
	//zastita
	do{
		printf("unesite broj n");
		scanf("%d",&n);
		printf("unesite broj m");
		scanf("%d",&m);
		
	}
	while(!(n>0 && m>0 && n<m));
	//kraj zastite
	printf("unesite broj koji se proverava");
	scanf("%lf",&broj);
	printf("opseg: \n\tn = %d \n\t m = %d",n,m);
	//petlja
	for(i=(double)n;i<=m;i++){
		if(i==(n+2))
		continue;
		
		else if(i%2==0)
			suma+=pow((double)i, (2/3));
		else if(i%2==1)
			suma-=pow((double)i, (3/2));
		 if(i==(n+3)){
		if(suma>10)
		printf("\n \t[i = %d] trenutna suma = %.2lf \n \t",i,suma);
		else
		printf("\n \t[i = %d] trenutna suma = %.1lf \n \t",i,suma);
		//zatvoren if
				}
			
		//zatvoren for
			}
			printf("\n\tuneti broj: %.3lf \n\t",broj);
			if(suma>broj)
				printf("\n\t ukupna suma je veca od broja %.3lf\n\t",broj);
				else
				printf("\n\t ukupna suma je manja od broja %.3lf\n\t",broj);
	
	
return 0;
}

