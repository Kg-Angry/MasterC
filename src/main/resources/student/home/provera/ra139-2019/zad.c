// Aleksandar Hornjak RA139-2019

#include <stdio.h>
#include <math.h>

int main() {
	
	int n;
	int m;
	int i;
	int trenutni_broj;
	double ukupna_suma = 0;
	double uneti_broj;
	
	do {
		printf("Opseg:\n\n");
		printf("\tn=");
		scanf("%d",&n);
		printf("\tm=");
		scanf("%d",&m);
	} while(n <= 0 || m <= 0 || m <= n);
	
	trenutni_broj = n;
	
	for(i = 0; i <= m-n; i++) {
		if (i == 2) {
			trenutni_broj++;
			continue;
		}
		
		if(trenutni_broj % 2 == 0) {
			ukupna_suma += 	pow( trenutni_broj, (2.0/3.0)) ;
		}
		else {
			
			ukupna_suma -=  pow( trenutni_broj, (3.0/2.0));;
		}
		if(i == 3){
			if(ukupna_suma > 10) {
				printf("[i=%d] trenutna suma= %.2lf\n",trenutni_broj, ukupna_suma);
			}
			else {
				printf("[i=%d] trenutna suma= %.1lf\n",trenutni_broj, ukupna_suma);
			}
		}
		trenutni_broj ++;
		
	}
	printf("\n\nUneti broj:");
	scanf("%lf",&uneti_broj);
	if(uneti_broj < ukupna_suma) {
		printf("\n\t ukupna suma je veca od broja %.3lf\n",uneti_broj);
	}
	else if(uneti_broj > ukupna_suma) {
		printf("\n\t ukupna suma je manja od broja %.3lf\n",uneti_broj);
	}
	else {
		printf("\n\t ukupna suma je jednaka sa brojem %.3lf\n",uneti_broj);
	}
	
	return 0;
}
