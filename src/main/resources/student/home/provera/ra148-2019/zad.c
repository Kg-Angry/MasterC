// Natasa Tatalovic c RA148-2019

#include <stdio.h>
#include <math.h>
int main () {

int n, m,i; 
double a,c, suma;
do {

scanf("%d", &n);
scanf("%d", &m);
printf("n= %d\n",n);
printf("m = %d\n",m);
}
while (!((n>0) && (m>0) && (m>n))); 



for(i=n;i<=m;i++)
{
suma = 0; 
if(i%2==0)
{
c=pow(i*i, 1/3);
suma= suma + c;

}
else
{
a = pow(i*i*i,1/2);
suma= suma-a; 
}

if (i==3)
{
continue;
}

if(i==5)
{
if(suma>10)
{printf("[i= %d]trenutna suma = %.2lf\n",i,a);
}
else 
{printf("[i= %d]trenutna suma = %.1lf\n",i,a);}
}

}
double u;
scanf("%lf", &u);
printf("\nUneti broj: %.0lf",u);


if(suma<=u)
{
printf("\tukupna suma je manja od broja %.3lf",u);}

else {
printf("\tukupna suma je veca od broja %.3lf",u);}


return 0; }
