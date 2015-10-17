#include <stdio.h> 
#include <omp.h> 
#define N 40 
int main (int argc, char *argv[]){ 
	  int   A[N], B[N], C[N]; 
	  int   i, j, n; 
	  int  tid, nthreads;

	  for (i=0; i<N; i++) A[i] = i; 
	  for (i=0; i<N; i++) B[i] = 2*i;
	  for (i=0; i<N; i++) C[i] = 0;
	  #pragma omp parallel private(nthreads, tid,n)
	{
		  tid = omp_get_thread_num();
		  nthreads = omp_get_num_threads();
		  #pragma omp parallel for
		  for(n=0; n < N; n++){
		    C[n] = A[n] + B[n];
		  } 

		 
		  printf ("\n      Vector C \n\n"); 
		  for (i=0; i<N; i++) { 
		    printf("%3d ", C[i]); 
		    printf (" "); 
		  }   
	} 
}
