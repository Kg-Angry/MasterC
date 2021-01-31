// Luka Pikula RA146-2019
#include <stdio.h>
#include <math.h>

int main(){

	int n,m;
	float broj;
	float suma=0;
	do{
		printf("Unesite prirodan broj n: ");
		scanf("%d",&n);
	}while(n<0);
	//Unos n i zastita unosa
	do{
		printf("Unesite prirodan broj m: ");
		scanf("%d",&m);
	}while(m<0 || m<=n);
	//Unos m i zastita unosa
	int i;
	int brojiteracija=0;
	for(i=n;i<=m;i++)
	{
		if(brojiteracija==3 ) //ako nije 3
		{
			brojiteracija++;
			
		}
		else
		{
			if(i%2==0)
			{
				float temp = pow(pow(i,2.0),1/3.0);
				suma+=temp; //Ako je paran dodajem
			}
			else
			{
				float temp = sqrt(pow(i,3.0));
				suma-= temp;	//ako je neparan oduzimam
			}
			
			if(brojiteracija == 4) //ako je 4 iteracija ispisujem
			{
				if(suma>10)
				{
					printf("Trenutna suma[%d]: %.2f",i,suma);
				}
				else
				{
					printf("Trenutna suma[%d]: %.1f",i,suma);
				}
				
			}
			brojiteracija++;
		}
		
	}
	printf("\n Unesite proizvoljan broj: ");
	scanf("%f",&broj);
	printf("Uneti broj je: %f \n",broj);
	
	if(suma>broj)
	{
		printf("Ukupna suma je veca od unetog broja %.3f \n",broj);
	}
	
	if(suma<broj)
	{
		printf("Ukupna suma je manja od unetog broja %.3f \n",broj);
	}
	
	if(suma==broj)
	{
		printf("Ukupna suma je jednaka sa unetim brojem %.3f \n",broj);
	}

	return 0;	
}
