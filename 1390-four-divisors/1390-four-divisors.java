class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            int count = 0;
            int sum = 0;
            int sqr = (int)Math.sqrt(num);
            if(sqr*Math.sqrt(sqr) == num){
                count = -3;
            } else if(sqr*sqr == num){
                count = -1;
            }
            for(int i = 1; i<=sqr; i++){
                if(num%i == 0){
                    sum += i + num/i;
                    count+=2;
                }
                if(count > 4){
                    sum = 0;
                    break;
                }
            }
            if(count == 4){
                totalSum += sum;
            }
        }
        return totalSum;
    }
}