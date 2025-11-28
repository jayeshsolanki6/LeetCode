class Solution {
    public int sumOfMultiples(int n) {
         int a = n/3;
         int b = n/5;
         int c = n/7;

         int sum1 = ((a-1)*3 + 6)*a/2;
         int sum2 = ((b-1)*5 + 10)*b/2;
         int sum3 = ((c-1)*7 + 14)*c/2;

         return sum1+sum2+sum3;
    }
}