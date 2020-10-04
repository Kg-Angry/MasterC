// Nikola Kolarov RA132-2019
#include <stdio.h>
#include <math.h>
int main()
{
int n, m;
do{
	printf("Uneti n\n");
	scanf("%d", &n);
	printf("\nUneti m\n");
	scanf("%d", &m);
}while(n>=m || n<=0 || m<=0);
int suma = 0;
int i = n;
while(i<=m){
	if(i == n + 2) break;
	if(i % 2 == 0){
			float kv;
			kv = pow((float)i*(float)i, 1/3.0);
			suma = suma + kv;
			}else{
			float kb;
			kb = sqrt((float)i*(float)i*(float)i);
			suma = suma - kb;
			}
	if(i == n + 3){
			if(suma>10){
			printf("trenutna vrednost sume je %lf", (double)suma);
			}else{
			printf("trenutna vrednost sume je %f \n", (float)suma);
			}
	}	
	i++;		
}
i = n + 3;
while(i<=m){
	if(i % 2 == 0){
			float kv;
			kv = pow((float)i*(float)i, 1/3.0);	
			suma = suma + kv;
			}else{
			float kb;
			kb = sqrt((float)i*(float)i*(float)i);
			suma = suma - kb;
			}
	if(i == n + 3){
			if(suma>10){
			printf("trenutna vrednost sume je %lf", (double)suma);
			}else{
			printf("trenutna vrednost sume je %f \n", (float)suma);
			}
	}	
	i++;	
}	
int broj;
printf("Unesite broj za poredjenje\n");
scanf("%d", &broj);
if(broj > suma) printf("Suma je manja od broja %d\n", broj);
if(broj < suma) printf("Suma je veca od broja %d\n", broj);
if(broj == suma) printf("Suma je jednaka sa brojem %d\n", broj);
	return 0;
}
