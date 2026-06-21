class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        // Use difference array to mark illuminated ranges
        int[] diff = new int[n];
        // Mark ranges illuminated by existing bulbs
        for (int i = 0; i < n; i++) {
            if (lights[i] > 0) {
                int left = Math.max(0, i - lights[i]);
                int right = Math.min(n - 1, i + lights[i]);
                
                diff[left]++;
                if (right + 1 < n) {
                    diff[right + 1]--;
                }
            }
        }
        
        // Count additional bulbs needed
        int additionalBulbs = 0;
        int illuminatedCount = 0;
        int consecutiveUnilluminated = 0;
        
        for (int i = 0; i < n; i++) {
            illuminatedCount += diff[i];
            
            if (illuminatedCount <= 0) {
                // Position i is not illuminated
                consecutiveUnilluminated++;
            } else {
                // Position i is illuminated, so install bulbs for unilluminated stretch
                additionalBulbs += Math.ceil(consecutiveUnilluminated / 3.0);
                consecutiveUnilluminated = 0;
            }
        }
        
        // Handle remaining unilluminated positions at the end
        additionalBulbs += Math.ceil(consecutiveUnilluminated / 3.0);
        
        return additionalBulbs;
    }
}