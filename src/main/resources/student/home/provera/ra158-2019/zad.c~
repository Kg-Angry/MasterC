// Aleksa Djurdjevic RA158-2019

#include <stdio.h>
#include <math.h>

int main(){
int n,m;
int i;
double s;
double suma=0;
do{
	printf("Opseg:\n");
	printf("	n=");
	scanf("%d",&n);
	printf("\n	m=");
	scanf("%d",&m);
}while(m<=n);
for(i=n;i<=m;i++){
s=i;
	if(i-n==2)
		continue;
	if(i%2==0)
		suma=suma+pow(s,2/3.0);
	else
		suma=suma-pow(s,3/2.0);
	if(i-n==3){
		if(suma>10)
		printf("[i = %d ] trenutna suma = %.2lf\n",i,suma);
		else
		printf("[i = %d ] trenutna suma = %.1lf\n",i,suma);
		}
}
printf("Uneti broj:");
scanf("%lf",&s);
if(suma<s)
	printf("\n	ukupna suma je manja od broja %.3lf\n", s);
else if(suma>s)
	printf("\n	ukupna suma je veca od broja %.3lf\n", s);
else
	printf("\n	ukupna suma je jednaka broju %.3lf\n", s);
return 0;
}
