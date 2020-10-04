// Pavle Vukovic RA135-2019

#include <stdio.h>
#include <math.h>

int main ()
{

int n,m,i;
double suma,br;

do
{

printf("Opseg:\n");

printf("\t n=");
scanf("%d", &n);

printf("\n");

printf("\t m=");
scanf("%d", &m);

printf("\n");
}
while(n>=m);

suma=0;

for (i=n;i<=m;i++)
{
if(i==n+2) //treca iteracija
{
continue;
}

if (i%2==0)
{
suma=suma+pow(pow(i,2.0),1.0/3);
}
else
{
suma=suma-pow(pow(i,3),1.0/2);
}

if(i==n+3)
{


if (suma>10)
{
printf("Trenutna suma =:%.2lf\n", suma);
}
else 
{
printf("Trenutna suma =:%.1lf\n", suma);
}

}
}

printf("\n\n");

printf("Uneti broj:");
scanf("%lf", &br);

if(suma>br)
printf("\t ukupna suma je veca od broja %.3lf\n", br);
else if(suma==br)
printf("\t ukupna suma je jednaka broju %.3lf\n", br);
else 
printf("\t ukupna suma je manja od broja %.3lf\n", br);

return 0;
}
