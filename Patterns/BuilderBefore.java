package Patterns;

// Complex object with many parameters
class Meal {
    // Mandatory fields
    private String mainCourse;
    private String size;
    
    // Optional fields
    private String sideDish;
    private String drink;
    private String dessert;
    private boolean extraCheese;
    private boolean spicy;
    private String sauce;
    private String specialInstructions;
    
    
    public Meal(String mainCourse, String size) {
        this.mainCourse = mainCourse;
        this.size = size;
    }
    
    public Meal(String mainCourse, String size, String sideDish) {
        this.mainCourse = mainCourse;
        this.size = size;
        this.sideDish = sideDish;
    }
    
    public Meal(String mainCourse, String size, String sideDish, String drink) {
        this.mainCourse = mainCourse;
        this.size = size;
        this.sideDish = sideDish;
        this.drink = drink;
    }
    
    public Meal(String mainCourse, String size, String sideDish, String drink, 
                String dessert) {
        this.mainCourse = mainCourse;
        this.size = size;
        this.sideDish = sideDish;
        this.drink = drink;
        this.dessert = dessert;
    }
    
    public Meal(String mainCourse, String size, String sideDish, String drink, 
                String dessert, boolean extraCheese, boolean spicy) {
        this.mainCourse = mainCourse;
        this.size = size;
        this.sideDish = sideDish;
        this.drink = drink;
        this.dessert = dessert;
        this.extraCheese = extraCheese;
        this.spicy = spicy;
    }
    
    // ... even more constructors needed!
    
    // Getters
    public String getMainCourse() { return mainCourse; }
    public String getSize() { return size; }
    public String getSideDish() { return sideDish; }
    public String getDrink() { return drink; }
    public String getDessert() { return dessert; }
    public boolean hasExtraCheese() { return extraCheese; }
    public boolean isSpicy() { return spicy; }
    public String getSauce() { return sauce; }
    public String getSpecialInstructions() { return specialInstructions; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Meal Order ===\n");
        sb.append("Main Course: ").append(mainCourse).append(" (").append(size).append(")\n");
        if (sideDish != null) sb.append("Side Dish: ").append(sideDish).append("\n");
        if (drink != null) sb.append("Drink: ").append(drink).append("\n");
        if (dessert != null) sb.append("Dessert: ").append(dessert).append("\n");
        if (extraCheese) sb.append("Extra Cheese: Yes\n");
        if (spicy) sb.append("Spicy: Yes\n");
        if (sauce != null) sb.append("Sauce: ").append(sauce).append("\n");
        if (specialInstructions != null) sb.append("Special Instructions: ").append(specialInstructions).append("\n");
        return sb.toString();
    }
}

// Usage - Confusing and error-prone
public class BuilderBefore {
    public static void main(String[] args) {
        // Which parameter is which? Easy to make mistakes!
        Meal meal1 = new Meal("Burger", "Large", "Fries", "Coke", "Ice Cream", true, false);
        
        // What if I only want main course and dessert? Need to pass nulls
        Meal meal2 = new Meal("Pizza", "Medium", null, null, "Brownie");
        
        // Very hard to read and maintain
        System.out.println(meal1);
    }
}