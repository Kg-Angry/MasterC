// Mihailo Trifkovic RA36-2019

#include <stdio.h>
#include <math.h>

int main()
{
	int n, m, i, k = 0;
	double s = 0, broj;
	
	printf("\n");
	do{
		printf("Opseg:  ");
		
		printf("\n\tn = ");
		scanf("%d",&n);
		
		printf("\n\tm = ");
		scanf("%d",&m);
	
		printf("\n");
	}while(m <= 0 || n <= 0 || n >= m);
	
	for(i = n; i <= m; i++){
		
		k++;
		if(k == 3) 
			continue;
		if(i % 2 == 0)
			s += pow(i*i, 1.0/3);
		else
			s -= pow(i*i*i, 1.0/2);
		if(k == 4){
			if(s > 10)
				printf("\n[i = %d] trenutna suma = %.2lf\n", k+1, s);
			else
				printf("\n[i = %d] trenutna suma = %.1lf\n", k+1, s);		
		}
		
	}
	printf("\nUneti broj:  ");
	scanf("%lf",&broj);
	
	if(s > broj)
		printf("\n\tUkupna suma je veca od broja %.3lf\n\n", broj);
	else
		printf("\n\tUkupna suma je manja od broja %.3lf\n\n", broj);

return 0;
}

