// Ivana Lazarevic RA137-2019

#include <stdio.h>
#include <math.h>
int main ()


{
	int n, m;
		do{
		
		printf("Unesite neki prirodan broj m: ");
		scanf("%d", &m);
		}while(n<1);
		
		do{
			printf("Unesite neki prirodan broj n,tako da vazi n<m:");
			scanf("%d", &n);
		
		}while(n<1 || n>m);
			
	int i,suma;
		suma=0;
		for(i=n; i<=m; i++)
		{ if(i%2==0)
		{ 	suma=suma+i+ pow(pow(i,2),1/3);
		 
		 if (i%)
		
		
		}
		
		}
		

return 0;
}
