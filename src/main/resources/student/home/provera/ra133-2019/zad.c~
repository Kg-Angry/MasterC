// David Mijailovic RA133-2019

#include<stdio.h>
#include<math.h>

int main(){

double s=0;
double n,m;
int i;
double broj;

do{
printf("Opseg:\n\tn = ");
scanf("%lf",&n);
}while(n<=0);

printf("\n\t");

do{
printf("m = ");
scanf("%lf",&m);
}while(m<n || m<=0);

for(i=n;i<=m;i++){

	if(i == n+2){
		continue;
	}

	if(i == n+3){
	if(i%2==0)
		s=s+pow((double)i,1/2);
	
	else s=s-pow((double)i,1/3);
	
	if(s>10)
		printf("[i=%d] trenutna suma =%.2lf\n",i,s);
	else printf("[i=%d] trenutna suma =%lf\n",i,s);
	}
}	
printf("Uneti broj:");
scanf("%lf",&broj);
if(s<broj)
printf("\n\tukupna suma je manja od broja:%.3lf\n",broj);
else printf("\n\tukupna suma je veca od broja:%lf\n",broj);

return 0;
}

