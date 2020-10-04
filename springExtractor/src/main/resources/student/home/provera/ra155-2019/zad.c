//Ognjen Stojisavljevic RA155-2019

#include <stdio.h>
#include <math.h>

int main(){

	int n,m,i;
	double suma=0,broj;
	
	do{
		printf("Opseg:\n\n\tn=");
		scanf("%d",&n);
		
	}while(n<1);
	
	do{
		printf("\tm=");
		scanf("%d",&m);
		
	}while(m<1 || m<=n);
	
	int j=1;
	
	for(i=n;i<=m;i++)
	{		
	
		if(j%3!=0)
		{
			if(i%2==0) suma=suma+pow(i,(2.0/3.0));
			else suma=suma-sqrt(pow(i,3));
		
		
			if(j%4==0)
			{	
				if(suma>10) 
				{
				printf("[i=%d] trenutna suma=%.2lf\n",i,suma);
				}
				else{
				 printf("[i=%d] trenutna suma=%.1lf\n",i,suma);
				}
			}
		
		
		
		}
		
		j++;
		
	}
	
	scanf("%lf",&broj);
	
	printf("\nUneti broj:%lf",broj);
	
	if(suma>=broj) printf("\n\t\t ukupna suma je veca ili jednaka od broja %.3lf\n\n",broj);
	else printf("\n\t\t ukupna suma je manja od broja %.3lf\n\n",broj);

	return 0;
	
}

