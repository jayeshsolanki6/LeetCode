class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min = Integer.MAX_VALUE;
        int d = -1;
        int i = 0;
        for(int[] drone : drones){
            int dis = Math.abs(drone[0]-target[0]) + Math.abs(drone[1]-target[1]);
            if(dis <= drone[2]){
                if(dis < min){
                    min = dis;
                    d = i;
                }
            }
            i++;
        }
        return d;
    }
}