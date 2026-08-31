/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let len = nums.length;
    let j = 0;
    for(let i = 0; i<len; i++){
        if(nums[i] !== 0){
            nums[j] = nums[i];
            if(i!=j){
                nums[i] = 0;
            }
            j++;
        }
    }
};