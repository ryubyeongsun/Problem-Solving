#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr1_len은 배열 arr1의 길이입니다.
// arr2_len은 배열 arr2의 길이입니다.
int solution(int arr1[], size_t arr1_len, int arr2[], size_t arr2_len) {
    
    int a = arr1_len;
    int b = arr2_len;
    
    if (a==b){
        int sum = 0;
        int sum2 = 0;
        for(int i=0; i<a; i++){
            
            sum+=arr1[i];
            sum2+=arr2[i];
         
        }

        if(sum<sum2){
            return -1;
        }
        else if(sum==sum2)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
      
    else if(a<b)
    {
        return -1;
    }
    else
    {
        return 1;
    }
    
}