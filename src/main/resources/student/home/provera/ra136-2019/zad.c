// Aleksa Spasojevic RA136-2019
#include <stdio.h>
#include <math.h>

int main()
{
	int n,m,i;
	float suma=0,broj;
	
	do
	{
		printf("Opseg:\n");
		printf("N=");
		scanf("%d",&n);
		printf("M=");
		scanf("%d",&m);
		
	}
	while((n>=m) || (n<0 || m<0) || n%1!=0 || m%1!=0);
	
	for(i=n; i <=m; i++)
	{
		if ( i == n+2)
		{
			continue;
		}
		
		if ( i % 2 == 0)
		{
			suma += pow(i*1.0,2.0/3.0);
		}
		else
		{
			suma -= pow(i*1.0,3.0/2.0);
		}
		
		if ( i == n+3)
		{
			if ( suma > 10)
			{
				printf("[i=%d] trenutna suma je=%.2f\n",i,suma);
			}
			else
			{
				printf("[i=%d] trenutna suma je=%.1f\n",i,suma);
			}
			
		}
	}
	
	printf("Unesite broj=");
	scanf("%f",&broj);
	
	if ( suma > broj)
	{
		printf("Ukupna suma je veca od broja %.3f\n",broj);
	}
	else if ( suma < broj)
	{
		printf("Ukupna suma je manja od broja %.3f\n",broj);
	}
	else
	{
		printf("Ukupna suma je jednaka sa brojem %.3f\n",broj);
	}
	
	return 0;
}

