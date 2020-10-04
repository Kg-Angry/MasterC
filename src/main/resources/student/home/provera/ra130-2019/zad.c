// Bojana Karanovic RA130-2019
#include <stdio.h>
#include <math.h>

int main(){
	int n,m,i;
	double suma=0,kvadrat,koren,kub;
	do{
		printf("Opseg:\n");
		printf("n= ");
		scanf("%d",&n);
		printf("\n");
		printf("m= ");
		scanf("%d",&m);
	}while(n>=m || n<1 || m<1 );
	

	i=1;
	for(n; n<=m; n++){
		if (i!=3){
			if(n%2==0){
				kvadrat=pow(n,2.0);
				koren=pow(kvadrat,1.0/3);
				suma+=koren;
			}
		
			else {
				kub=pow(n,3);
				koren=sqrt(kub);
				suma-=koren;				
			}
		}else{
			suma=suma;
			
		}
		if (i==4){
			if (suma>10){
				printf("[i=%d] trenutna suma = %.2lf\n",n,suma);
			}else{
				printf("[i=%d] trenutna suma = %.1lf\n",n,suma);
			
			}
		}
		
		i++;
	}
	double broj;
	printf("Uneti broj: ");
	scanf("%lf",&broj);
	
	if (broj>suma){
		printf("ukupna suma je manja od broja %.3lf. \n",broj);
	}
	else if (broj == suma){
		printf("ukupna suma je jednaka broju %.3lf. \n",broj);
	}
	else{
		printf("ukupna suma je veca od broja %.3lf. \n",broj);
	}
	
	
	return 0;
}

