class Solution {
    public int findRepeatNumber(int[] nums) {
        //代码规范：可以把异常情况先处理
        if(nums == null || nums.length == 0)
            return -1;
        int temp;
        for(int i=0;i<nums.length;i++)
            if(nums[i] != i){
                if(nums[i] == nums[nums[i]])
                    return nums[i];
                else{
                    temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[temp] = temp;
                    i--;
                }
            }
        return -1;
    }
}

//注意：交换 num[i] 与 num[num[i]] 时，num[i]会发生改变，因此需要将 num[num[i]] 改成 num[temp] ，不然会陷入死循环。
