// Petar Popovic RA150-2019
#include<stdio.h>
#include<math.h>
 int main(){
  int n,m,i;
  double S,k;
  
  do{
   printf("\nOpseg :\n\n\tn=");
   scanf("%d",&n);
  }while(n<1);
  
  do{
  printf("\n\n\tm=");
  scanf("%d",&m);
  }while(m<=n);
  
  for(i=n,S=0; i<=m; i++){
  
   if(i==n+2) continue;

   if(i%2==0)
   S+=pow(i,2.0/3.0);
  
       else S-=pow(i,3.0/2);
  
  
   if(i==n+3){
  
   if(S>10) printf("\n[i=%d] trenutna suma = %.2lf",i,S);
  
       else printf("\n[i=%d] trenutna suma = %.1lf\n",i,S);
   }

   }
  printf("\n\nUneti broj:");
  scanf("%lf",&k);
   
   if(S<k) printf("\n\t\tukupna suma je manja od broja %.3lf\n",k);
   if(S>k) printf("\n\t\tukupna suma je veca od broja %.3lf\n",k); 
   if(S==k) printf("\n\t\tukupna suma je jednaka broju %.3lf\n",k);
 
 return 0;
 }


