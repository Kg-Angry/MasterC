// Stefan Apostolovic RA143-2019
#include <stdio.h>
#include <math.h>
int main()
{
	int n, m, i;
	double suma = 0, k;
	
		printf("\nOpseg: \n");
		printf("\n");
		printf("\t");
	do{
		printf("\n");
		printf("\t");
		printf("n = ");
		scanf("%d", &n);
	}
	while(n<=0);
		printf("\n");
		printf("\t");
	do{
		printf("\n");
		printf("\t");
		printf("m = ");
		scanf("%d", &m);
	}
	while(m<=0 || m<=n);
	
	for(i=n;i<=m;i++)
	{
		if(i==n+2){
			continue;
		}
		
		if(i%2==0)
		{
			suma = suma + pow(pow(i,2),1/3.0);
		}
		else{
			suma = suma - pow(pow(i,3),1/2.0);
		}
		
		if(i==n+3){
			if(suma>10)
			{
				printf("\n[i=%d] trenutna suma = %.2lf\n", i,suma);
			}
			else{
				printf("\n[i=%d] trenutna suma = %.1lf\n", i,suma);
			}
		}
	}
	
	printf("\nUneti broj: ");
	scanf("%lf", &k);
	
	if(suma>k)
	{
		printf("\t\tukupna suma je veca od broja %.3lf\n", k);
	}
	else if(suma==k)
	{
		printf("\t\tukupna suma je jednaka broju %.3lf\n", k);
	}
	else if(suma<k)
	{
		printf("\t\tukupna suma je manja od broja %.3lf\n", k);
	}
	
	return 0;
}

