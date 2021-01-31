// Matija Medic-Glusac RA147-2019
#include <stdio.h>
#include <math.h>

int main(){
	int n,m,i;
	double sum=0;
	double input_num;
	int count=0;
	double sabirak;
	
	do{
		printf("Opseg:\n");
		
		printf("n = ");
		scanf("%d",&n);
		printf("\n");
		
		printf("m = ");
		scanf("%d",&m);
		printf("\n");
		
	}while(n<0 || m<0 || m<n);	
	
	//printf("n=%d,m=%d",n,m);
	for(i=n; i<=m; i++){
		//printf("sum broj:%lf",sum);
		if(count == 2){
			count++;
			continue;
		}
		
		if(i%2==0){
			//printf("paran  %d \n",i);
			sabirak = pow((i*i),1/3.0);	
			sum+=sabirak;
		}
		if(i%2==1){
			//printf("neparan %d\n", i);
			sabirak= pow(i*i*i,1/2.0);
			sum-= sabirak;
		}
		if(count ==3){
			printf("[i=%d] trenutna suma = %.1lf\n",count+2,sum);
		}
		count++;	
	}
	
	printf("Uneti broj: ");
	scanf("%lf",&input_num);
	printf("\n");
	
	if(sum<input_num){
		printf("Ukupna suma je manja od broja %.3lf\n",input_num);
	}
	if(sum>input_num){
		printf("Ukupna suma je veca od broja %.3lf\n",input_num);
	}
	if(sum == input_num){
		printf("Ukupna suma je jednaka broju %.3lf\n",input_num);
	}
	
return 0;	
}

