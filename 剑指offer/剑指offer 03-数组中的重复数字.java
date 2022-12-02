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

// 思路：遍历数组，查找下标 i 对应的元素是否为 i ：
// - 若是，则继续遍历下一个元素；
// - 若不是，则判断该下标的元素 (m) 是否与其作为下标对应的元素 (nums[m]) 相等： 
//        -     若不相等，则交换这两个元素，回到 i 坐标重复上述操作；
//        -     若相等，则返回该元素
// 注意：交换 num[i] 与 num[num[i]] 时，num[i]会发生改变，因此需要将 num[num[i]] 改成 num[temp] ，不然会陷入死循环。
