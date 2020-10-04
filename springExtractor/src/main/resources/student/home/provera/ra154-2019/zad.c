// Nenad Maricic Ra154-2019
#include<stdio.h>
#include<math.h>
int main () {
int n,m;
do {  
printf ("Opseg\n");
printf("n=");
scanf("%d",&n);
printf("m=");
scanf("%d",&m);
}
while (!(n>0 && m>n));
int i;
double sum=0;
double parnouvecanje, neparnouvecanje;
for (i=n; i<=m; i++){
if (i%2==0){
parnouvecanje=pow(pow(i,2),(1/3));
sum=sum+parnouvecanje; break;}
else if (i%2!=0){
neparnouvecanje=sqrt(pow(i,3));
sum=sum-neparnouvecanje; break;}
}
if (sum>10)
printf("[i=%d] trenutna suma %.2lf\n",i,sum);
else 
printf("[i=%d] trenutna suma %.1lf\n",i,sum);
double s;
printf("Uneti broj");
scanf("%lf",&s);
if (sum<s)
printf ("konacna suma je manja od broja %.3lf\n",s);
else if (sum>s) 
printf ("konacna suma je veca od broja %.3lf\n",s);
else 
("konacna suma je jednaka sa brojem %.3lf\n",s);
return 0;
}
