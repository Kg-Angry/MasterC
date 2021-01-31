// Bozidar Krunic RA160-2019
#include <stdio.h>
#include <math.h>

int main(){

int n,m;
         do{
         printf("Unesite prirodan broj n: ");
         scanf("%d", &n);
         }while(n<=0);

         do{
         printf("Unesite prirodan broj m: "); 
         scanf("%d", &m);
         }while(m<n);
         
int sum=0;
int i;        
        for(i=n;i<=m;i++){
        
               if(i-n==2){
                continue;
                }      
        	if(i%2==0){ 
                sum=sum+pow(i*i,1/3.0);  
                
             
                }else{
                 sum=sum-pow(i*i*i,1/2.0);
                }
                
                if(i-n==3){
                  if(sum>10){
                  printf("\n i=[%d]trenutan suma =%d.2\n\n",i, sum);                
                }else{
                 printf("\n i=[%d] trenutna suma =%d.1\n\n",i,sum); 
                 }
                 
                 
                 int br;

     printf("\n Unesi neki broj: ");
     scanf("%d",&br);

     if(br>=sum){
        printf("\n Uneti broj:%d\n uneta suma je manja od %d\n",br,br);
        }else if(br<=sum){
                printf("\n Uneti broj:%d\n unetasuma je veca od %d\n",br,br);
                }
                
                }
                 
                 
                 
	}

             
}

      




return 0;
}
