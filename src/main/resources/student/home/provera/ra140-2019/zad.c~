// Dusan Stojkovic RA140-2019

#include<stdio.h>
#include<math.h>

int main()
{
	int i;
	int j = 0;
	int n = 0,m = 0;
	float sum = 0.;
	float exp;
	
	do
	{
		printf("Opseg: \n\n");
		printf("\tn = ");
		scanf("%i", &n);
		printf("\n\tm = ");
		scanf("%i", &m);
		printf("\n");
	}while(!(m > n && n > 0 && m > 0));
	
	for(i = n; i <= m; i++)
	{
		if(j < 4)
		{
			j++;
			if(j == 3)
			continue;
		}
		if(i % 2 == 0)
		{
			sum +=	pow(pow(i, 2), 1.0/3);	
		}
		else
		{
			sum -= sqrt(pow(i, 3));
		}
		
		if(j == 4)
		{
			if(sum > 10)
			{
				printf("[i = %i] trenutna suma = %.2f	 \n\n", i, sum);
			}
			else
			{
				printf("[i = %i] trenutna suma = %.1f	 \n\n", i, sum);
			}
			j++;
		}
	}
	
	float test;
	printf("Uneti broj: ");
	scanf("%f", &test);
	
	if(sum > test)
	{
		printf("ukupna suma je veca od broja %.3f \n", test);
	}
	else if(sum < test)
	{
		printf("ukupna suma je manja od broja %.3f \n", test);
	}
	else
		printf("ukupna suma je jednaka broju %.3f \n", test);
}

