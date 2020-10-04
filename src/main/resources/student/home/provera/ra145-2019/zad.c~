// Jovan Srdanov RA145-2019
#include<stdio.h>
#include<math.h>
int main(){
int n,m,i;
float suma,broj;
suma=0;


do{	
	printf("Uneti n: ");
	scanf("%d",&n);
	
	printf("Uneti m: ");	
	scanf("%d",&m);
	
}while( (n<=0) || (m<=0) || (n>=m) );

for(i=n;i<=m;i++)
	{ 
	if(i!=n+2){	
	if(i%2==1){suma=suma-pow(i,3/2.0);}
	if(i%2==0) {suma=suma+pow(i,2/3.0);}
		
	
	if(i==n+3){if(suma>10)printf("[i = %d] trenutna suma = %.2f\n",i,suma);
	else printf("[i = %d] trenutna suma = %.3f\n",i,suma);}
	}
	
	}
	
printf("\nUneti broj: ");
scanf("%f",&broj);

if(suma>broj)printf("\nukupna suma je veca od broja %.3f\n",broj);

if(suma<broj)printf("\nukupna suma je manja od broja %.3f\n",broj);

if(suma==broj)printf("\nsuma je jednaka broju %.3f\n",broj);
	

return 0;}


