// Dusko Radicic RA129-2019
#include<stdio.h>
#include<math.h>
int main(){
 float suma, broj;
 int n, m, brojac, i;
 do{
 printf("Opseg:\n");
 printf("n = ");
 scanf("%d", &n);
 printf("\nm = ");
 scanf("%d", &m);
 printf("\n");
 }while(n<1 || m<1 || n>=m);
 suma = 0;
 brojac = 0;
for(n;n<=m;n++){
	brojac++;
	if(brojac == 3){
	;}
	else if(brojac == 4){
		if(n%2==0){
		suma += pow(pow(n,2), 1.0/3);}
		else{
		suma -= sqrt(pow(n,3));}
		if(suma>10){
		printf("[i=%d] trenutna suma = %.2f\n", n, suma);}
		else{
		printf("[i=%d] trenutna suma = %.1f\n", n, suma);}
		}
	else{
		if(n%2==0){
		suma += pow(pow(n,2), 1.0/3);}
		else{
		suma -= sqrt(pow(n,3));}
	}
}

printf("\nUneti broj:\n");
scanf("%f", &broj);
if(suma < broj){
printf("Ukupna suma je manja od broja %.3f\n", broj);}

else if(suma == broj){
printf("Ukupna suma je jednaka broju %.3f\n", broj);}

else{
printf("Ukupna suma je veca od broja %.3f\n", broj);}



return 0;
}

