class Solution {
    public boolean check(int[] nums) {
        
        int n = nums.length;

        for(int i = 1; i < n ; i ++){
            if(nums[i] < nums[i-1]){
                reverse(nums , 0 , i-1);
                reverse(nums , i , n-1);
                reverse(nums , 0 , n-1);
                break;
            }
        }

        for(int i = 1 ; i < n ; i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }

        return true;
    }

    public void reverse(int [] nums , int start , int end){
         while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}