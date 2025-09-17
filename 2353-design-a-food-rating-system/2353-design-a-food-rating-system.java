class FoodRatings {
    Map<String, Integer> foodRating = new HashMap<>();
    Map<String, String> foodCuisine = new HashMap<>();

    Map<String, TreeSet<String>> cuisineFood = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0; i<n; i++){
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            cuisineFood.putIfAbsent(cuisines[i], new TreeSet<>(
                (a, b) -> {
                    int r1 = foodRating.get(a);
                    int r2 = foodRating.get(b);
                    return (r1 == r2) ? a.compareTo(b) : r2 - r1;
                }
            ));
            cuisineFood.get(cuisines[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        TreeSet<String> ts = cuisineFood.get(foodCuisine.get(food));
        ts.remove(food);
        foodRating.put(food, newRating);
        ts.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineFood.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */