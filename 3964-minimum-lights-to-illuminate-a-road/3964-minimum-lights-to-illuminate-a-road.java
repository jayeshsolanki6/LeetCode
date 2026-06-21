class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        
        // Use difference array to mark illuminated ranges
        int[] diff = new int[n];
        
        // Mark ranges illuminated by existing bulbs
        for (int i = 0; i < n; i++) {
            if (lights[i] > 0) {
                int l = Math.max(0, i - lights[i]);
                int r = Math.min(n - 1, i + lights[i]);
                
                diff[l]++;
                if (r + 1 < n) {
                    diff[r + 1]--;
                }
            }
        }
        
        // Count additional bulbs needed
        int add = 0;
        int illuCount = 0;
        int unilluCount = 0;
        
        for (int i = 0; i < n; i++) {
            illuCount += diff[i];
            
            if (illuCount <= 0) {
                // Position i is not illuminated
                unilluCount++;
            } else {
                // Position i is illuminated, install bulbs for unilluminated stretch
                add += Math.ceil(unilluCount / 3.0);
                unilluCount = 0;
            }
        }
        
        // Handle remaining unilluminated positions at the end
        add += Math.ceil(unilluCount / 3.0);
        
        return add;
    }
}