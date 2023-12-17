class Food implements Comparable<Food> {
    public int rating;
    public String name;

    public Food(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }

    @Override
    public int compareTo(Food other) {
        if (rating == other.rating) {
            return name.compareTo(other.name);
        }

        return -1 * Integer.compare(rating, other.rating);
    }
}

class FoodRatings {
    private Map<String, Integer> ratingMap;
    private Map<String, String> cuisineMap;
    private Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        ratingMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            ratingMap.put(foods[i], ratings[i]);
            cuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        ratingMap.put(food, newRating);

        String cuisine = cuisineMap.get(food);
        cuisineFoodMap.get(cuisine).add(new Food(newRating, food));
    }
    
    public String highestRated(String cuisine) {
        Food highestFood = cuisineFoodMap.get(cuisine).peek();

        while (ratingMap.get(highestFood.name) != highestFood.rating) {
            cuisineFoodMap.get(cuisine).poll();
            highestFood = cuisineFoodMap.get(cuisine).peek();
        }

        return highestFood.name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */