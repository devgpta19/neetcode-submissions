class Solution {
    static int[] nextPalindrome(int[] num) {
        // code here
        int mid = num.length%2 == 0 ? num.length/2 : (num.length-1)/2;
        
        int idx = mid;
        int n = mid;
        boolean flag = true;
        for(int i=0, j=num.length-1 ; i<j; i++,j--){
            if(num[i]!=num[j]){
                flag = false;
                break;
            }
        }
        if(flag){
            if(num.length%2 == 0){
                int i = num.length/2 - 1;
                num[i]+=1;
                num[i+1]+=1;
            }else{
                int i = (num.length+1)/2 - 1;
                num[i]+=1;
            }
            
            return num;
        } 
        
       for(int i = idx, j = (num.length % 2 == 0) ? mid : mid + 1; i >= 0 && j < num.length; i--, j++){
            if(num[i] >= num[j]){
                num[j] = num [i];
            }
            else{
                idx = j;
                break;
            }
        }
        
        if(idx == -1) return num;
        
        if(idx > -1){
            if(num.length % 2 == 0){
                int i = mid;
                int j = i-1;
                if(num[j]<num[i])
                num[j]++;
                num[i]=num[j];
                int x = 0;
                while(x < j){
                    num[num.length-1-x] = num[x];
                    x++;
                }
            }else{
                int i = mid;
                int j = mid;
                num[i] += 1;
                while(j<num.length && i>=0){
                    num[j]=num[i];
                    i--;j++;
                }
            }
        }
        
        int count = 0;
        while(mid > -1 && num[mid] >= 9){
            num[mid] = 0;
            mid --;
            count++;
            if(mid == -1){
                break;
            }
            num[mid] += 1;
        }
        
        if(count < n+1 && count > 0 && mid != -1){
            for(int i=0,j=num.length-1;i<j;i++,j--){
                num[j] = num[i];
            }
            return num;
        }
                
        if(mid == -1){
            int []arr = new int[num.length+1];
            arr[0] = 1;
            arr[arr.length-1] = 1;
            
            return arr;
        }
        
        return num;
    }
}