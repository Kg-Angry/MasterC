// Danilo Bulatovic RA159-2019
#include <stdio.h>
#include <math.h>

int main(){
	int n, m, i;
	double sum = 0, kvadrat, kub, x;
	
	printf("Opseg: \n\n");
	do{
		printf("\tn = ");
		scanf("%d", &n);
	}while(n < 1);
	printf("\n");
	do{
		printf("\tm = ");
		scanf("%d", &m);
	}while(m <= n);
	
	printf("\n");
	for(i = n; i <= m; i++){
		if(i == n+2){ //treca iteracija
			continue;
		}

		if(i%2 == 0){ //paran
			kvadrat = pow(i, 2);
			sum += pow(kvadrat, 1.0/3);
		}else if(i%2 == 1){ //neparan
			kub = pow(i, 3);
			sum -= sqrt(kub);
		}
		
		if(i == n+3){ //cetvrta iteracija
			if(sum > 10){
				printf("[i = %d] trenutna suma = %.2lf\n", i, sum);
			}
			else{
				printf("[i = %d] trenutna suma = %.1lf\n", i, sum);
			}
		}
	}
	printf("\n\n");
	printf("Uneti broj: ");
	scanf("%lf", &x);
	printf("\n");
	
	if(x > sum){ //x je veci od sume
		printf("\tukupna suma je manja od broja %.3lf\n", x);
	}else if(x < sum){ //x je manji od sume
		printf("\tukupna suma je veca od broja %.3lf\n", x);
	}else{ // x je jednak sumi
		printf("\tukupna suma je jednaka broju %.3lf\n", x);
	}
	printf("\n");
	
	return 0;
}
