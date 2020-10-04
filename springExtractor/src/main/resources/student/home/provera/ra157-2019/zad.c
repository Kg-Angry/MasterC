// Darko Selakovic RA157-2019

#include<stdio.h>
#include<math.h>
	int main(){
	int n,m;
	do{
		printf("Unesite n : ");
		scanf("%d",&n);
		printf("Unesite m : ");
		scanf("%d",&m);
	}
	while(!(m>n && n>0));
	
	int i,k=1;
	float s=0;
	
		for(i=n;i<m;i++){

if(i==(n+2)){
		k=0;
	    }
	    
					    
		if(k==1){
		
			
				if(i%2==0){
						s+=pow(pow(i,2),1/3);
					  }
			 	else{
			 			s-=sqrt(pow(i,3));
			 	     }
			 	     
		    }
 if(i==(n+3)){
		if(s>10){
				printf("[i=%d] trenutna suma=%.2f\n",i,s);
			}
		else{
				printf("[i=%d] trenutna suma=%.1f\n",i,s);	
		    }
	   }
					    
			k=1;
			}
			
			
			
			
			float br;
			printf("Uneti broj : ");
			scanf("%f",&br);
				if(s>br){
						printf("Ukupna suma je veca od %.3f\n",br);
					}
				else if(s<br){
						printf("Ukupna suma je manja od %.3f\n",br);
						}
				else if(s==br){
						printf("Suma je jednaka %.3f\n",br);
						}
			
	return 0;
	}
