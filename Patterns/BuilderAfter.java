package Patterns;

// 1. Product Class - The Pizza we want to build
class Pizza {
    // Data members WITHOUT final - can be changed
    private String size;
    private String crust;
    private String cheese;
    private String topping1;
    private String topping2;
    private boolean extraCheese;
    private boolean spicy;
    
    // Private constructor - only Builder can create Pizza
    private Pizza() {
        // Empty constructor
    }
    
    // Getters
    public String getSize() { return size; }
    public String getCrust() { return crust; }
    public String getCheese() { return cheese; }
    public String getTopping1() { return topping1; }
    public String getTopping2() { return topping2; }
    public boolean hasExtraCheese() { return extraCheese; }
    public boolean isSpicy() { return spicy; }
    
    // Setters - now we CAN have them (without final)
    public void setSize(String size) { this.size = size; }
    public void setCrust(String crust) { this.crust = crust; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    public void setTopping1(String topping1) { this.topping1 = topping1; }
    public void setTopping2(String topping2) { this.topping2 = topping2; }
    public void setExtraCheese(boolean extraCheese) { this.extraCheese = extraCheese; }
    public void setSpicy(boolean spicy) { this.spicy = spicy; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n========== PIZZA ORDER ==========\n");
        sb.append("Size: ").append(size != null ? size : "Not set").append("\n");
        sb.append("Crust: ").append(crust != null ? crust : "Not set").append("\n");
        sb.append("Cheese: ").append(cheese != null ? cheese : "Not set").append("\n");
        if (topping1 != null) sb.append("Topping 1: ").append(topping1).append("\n");
        if (topping2 != null) sb.append("Topping 2: ").append(topping2).append("\n");
        if (extraCheese) sb.append("Extra Cheese: Yes\n");
        if (spicy) sb.append("Spicy: Yes\n");
        sb.append("=================================\n");
        return sb.toString();
    }
    
    // 2. Static nested Builder class
    public static class PizzaBuilder {
        // Builder has its own copy of all fields
        private String size;
        
        
        // Empty constructor
        public PizzaBuilder() {
        }
        
        // Methods to set each property - return 'this' for chaining
        public PizzaBuilder size(String size) {
            this.size = size;
            return this;  // Return the builder itself
        }
        
        
        
        // build() method creates the Pizza and copies all values
        public Pizza build() {
            Pizza pizza = new Pizza();
            
            // Copy all values from builder to pizza
            pizza.setSize(this.size);
            
            return pizza;
        }
    }
}

// 3. Main class - How to use the Builder
public class BuilderAfter {
    public static void main(String[] args) {
        System.out.println("====== WELCOME TO PIZZA SHOP ======\n");
        
        // Example 1: Simple Margherita Pizza
        System.out.println("Customer 1: Simple Margherita");
        Pizza margherita = new Pizza.PizzaBuilder()
                .size("Medium")
                .crust("Thin Crust")
                .cheese("Mozzarella")
                .build();
        System.out.println(margherita);
        
        // Example 2: Fully Loaded Pizza
        System.out.println("Customer 2: Fully Loaded");
        Pizza deluxe = new Pizza.PizzaBuilder()
                .size("Large")
                .crust("Thick Crust")
                .cheese("Mozzarella")
                .topping1("Pepperoni")
                .topping2("Mushrooms")
                .extraCheese(true)
                .spicy(true)
                .build();
        System.out.println(deluxe);
        
        // Example 3: Custom Pizza with only some options
        System.out.println("Customer 3: Custom Order");
        Pizza custom = new Pizza.PizzaBuilder()
                .size("Small")
                .crust("Pan Crust")
                .cheese("Cheddar")
                .topping1("Olives")
                .build();
        System.out.println(custom);
        
        // Example 4: Basic Pizza - minimal options
        System.out.println("Customer 4: Basic Pizza");
        Pizza basic = new Pizza.PizzaBuilder()
                .size("Medium")
                .crust("Regular")
                .build();
        System.out.println(basic);
        
        // Without final, we CAN modify pizza after creation (though not recommended)
        System.out.println("Customer 1 changes mind about size:");
        margherita.setSize("Large");  // This is possible without final
        System.out.println(margherita);
    }
}