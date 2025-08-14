import java.util.Scanner;

public class WeatherAdvisorAgent {
    private Scanner scanner;
    
    public WeatherAdvisorAgent() {
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        System.out.println("=== Weather Advisor Agent ===");
        
        while (true) {
            try {
                System.out.print("Enter temperature (C): ");
                double temperature = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                
                System.out.print("Enter weather condition (sunny/rainy/snowy/cloudy): ");
                String weatherCondition = scanner.nextLine().toLowerCase().trim();
                
                if (!isValidWeatherCondition(weatherCondition)) {
                    System.out.println("Invalid weather condition. Please enter: sunny, rainy, snowy, or cloudy");
                    continue;
                }
                
                String recommendation = makeDecision(temperature, weatherCondition);
                
                System.out.println("\nWeather: " + temperature + "C and " + weatherCondition);
                System.out.println("Recommendation: " + recommendation);
                
                System.out.print("\nWould you like another recommendation? (yes or no): ");
                String again = scanner.nextLine().toLowerCase();
                if (!again.equals("yes") && !again.equals("yes")) {
                    System.out.println("Thank you for using Weather Advisor Agent!");
                    break;
                }
                System.out.println("\n========================================\n");
                
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }
    
    private boolean isValidWeatherCondition(String condition) {
        String[] validConditions = {"sunny", "rainy", "snowy", "cloudy"};
        for (String valid : validConditions) {
            if (valid.equals(condition)) {
                return true;
            }
        }
        return false;
    }
    
    private String makeDecision(double temp, String condition) {
        String baseClothing = "";
        
        if (temp < 10) {
            baseClothing = "Wear a heavy coat, warm sweater, long pants, and boots";
        } else if (temp >= 10 && temp <= 20) {
            baseClothing = "Wear a light jacket or sweater with long pants";
        } else if (temp > 20 && temp <= 30) {
            baseClothing = "Wear a t-shirt or light shirt with comfortable pants or shorts";
        } else {
            baseClothing = "Wear light, breathable clothing like shorts and a t-shirt";
        }
        
        if (condition.equals("rainy")) {
            return baseClothing + " with a raincoat or umbrella. Don't forget waterproof shoes!";
        } else if (condition.equals("snowy")) {
            if (temp > 0) {
                return baseClothing + " with waterproof boots and gloves. Consider a hat!";
            } else {
                return "Wear heavy winter gear: insulated coat, warm hat, gloves, scarf, and waterproof boots";
            }
        } else if (condition.equals("sunny")) {
            if (temp > 25) {
                return baseClothing + ". Don't forget sunglasses and sunscreen!";
            } else {
                return baseClothing + ". Perfect weather to enjoy outdoors!";
            }
        } else {
            return baseClothing + ". Great weather for outdoor activities!";
        }
    }
    
    public static void main(String[] args) {
        WeatherAdvisorAgent agent = new WeatherAdvisorAgent();
        agent.run();
    }
}