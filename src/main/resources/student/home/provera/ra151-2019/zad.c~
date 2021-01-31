// Ognjen Golubovic RA151-2019
#include <stdio.h>
#include <math.h>
int main()
{
	int n,m,i;
	double s=0,x;
	do{
	printf("Unesite n:");
	scanf("%d",&n);
	printf("Unesite m:");
	scanf("%d",&m);
	}while(n<1 || m<1 || n>=m);
	for(i=n;i<=m;i++)
	{
	if(i%2==0 && i!=n+2)
	{s= s + pow(i,2.0/3.0);
	} 
	if(i%2!=0 && i!=n+2)
	{s= s - pow(sqrt(i),3);
	}
	if(s>10 && i==n+3)
	{printf("[i=%d] trenutna suma = %.2lf\n ",i,s);}
	if(s<=10 && i==n+3)
	{printf("[i=%d] trenutna suma = %.1lf\n ",i,s);}
	}
	printf("\n Uneti broj:");
	scanf("%lf",&x);
	if(s<x)
	{printf("\n ukupna suma je manja od broja %.3lf\n",x);}
	if(s>x)
	{printf("\n ukupna suma je veca od broja %.3lf\n",x);}
	if(s==x)
	{printf("\n ukupna suma je jednaka broju %.3lf\n",x);}
	return 0;
}








