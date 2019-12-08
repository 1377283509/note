## LeetCode题目记录

###  53.最大子序和

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

```java
public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
```

### 66.加一

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

```java
public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
       digits[i]++;
       digits[i] = digits[i] % 10;
       if (digits[i] != 0) return digits;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
}
```

