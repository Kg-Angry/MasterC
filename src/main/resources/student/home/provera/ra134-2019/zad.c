// Dragan Zaric RA134-2019
#include<stdio.h>
#include<math.h>
int main(){
int i,n,m;
double k,suma=0;
do{
   printf("Unesi dva prirodna broja sa razmakom izmedju, tako da prvi bude manji od drugog\n");
   scanf("%d %d",&n,&m);
} while(!((n>0)&&(m>0)&&(m>n)));

for(i=n;i<=m;i++){
	if((i-n)%2==0){
		if(i==4){
		suma=suma+pow(i*1.0,2.0/3);
			if(suma>10)printf("[i=%d] trenutna suma = %.2lf\n",i-n+1,suma);}
		else printf("[i=%d] trenutna suma = %.1lf\n",i-n+1,suma);}
		
	else suma=suma+pow(i*1.0,2.0/3);
		};
		
	if((i-n)%2==1){
		if(i==2)
		;
		else suma=suma-pow(i*1.0,3.0/2);
	
		};
		
printf("Uneti broj: ");
scanf("%lf",&k);
if(suma>k*1.0)printf("ukupna suma je veca od broja %.3lf\n",k);
	else printf("ukupna suma je manja od broja %.3lf\n",k);
return 0;
}

