// Ivana Lazarevic RA137-2019

#include <stdio.h>
#include <math.h>
int main ()


{
	int n, m;
		do{
		
		printf("\t\nUnesite neki prirodan broj m: ");
		scanf("%d", &m);
		}while(m<1);
		
		do{
			printf("\n\tUnesite neki prirodan broj n,tako da vazi n<m:");
			scanf("%d", &n);
		
		}while(n<1 || n>m);
			
	int i;
	float suma,a;
	
	
	
	
		suma=0;
	
	
		printf("\n\tUnesite neki proizvoljan broj:");
		scanf("%f", &a);
	
		for(i=n; i<=m; i++)
		{ 
			
			if(i%2==0)
			{ 		if(i==n+2){break;}	
		
				else {
				suma=suma+ pow(pow(i,2),1/3);
					
					           
					           
					           
				}
		
			}
		
		 
		 	 else
		 	 {  if(i==n+2){break;}
		  
		  		 else {suma=suma-sqrt(pow(i,3));
		  		 
		  		 }
		  	 }
		  
		  	if(i==(n+3))
		  	{	
		  		if(i%2==0)
		  		{ suma=suma+ pow(pow(i,2),1/3);
		  			if(suma>10)
		  			{
		  			printf("[i=%d]=%.2lf\n", i, suma);
		  			}
		  		
		  			else {printf("[i=%d]=%.1lf\n", i, suma);}
		  		}
		  		          
		  		          
		  
		  		else
		  		 {
		  		 	suma=suma-sqrt(pow(i,3));
		  				if(suma>10)
		  				{
		  				printf("[i=%d]=%.2lf\n", i, suma);
		  				}
		  			
		  			else {printf("[i=%d]=%.1lf\n", i, suma);}}
		  		}
		  		
		  	}
		  	
		  	
		  
		
		
		
		 if(a>suma){printf("Ukupna suma je manja od  broja %.3lf!\n",a);}
		else {printf("Ukupna suma je manja od  broja %.3lf!\n", a);}
		
		

return 0;
}
