def weather_advisor_agent():
    """
    Simple reflex agent that suggests clothing based on weather conditions
    """
    print("=== Weather Advisor Agent ===")
    
    # Get input from environment (user)
    try:
        temperature = float(input("Enter temperature °C : "))
        weather_condition = input("Enter weather condition (sunny/rainy/snowy/cloudy): ").lower().strip()
    except ValueError:
        print("❌ Invalid temperature input. Please enter a number.")
        return
    
    # Validate weather condition
    valid_conditions = ["sunny", "rainy", "snowy", "cloudy"]
    if weather_condition not in valid_conditions:
        print("❌ Invalid weather condition. Please enter: sunny, rainy, snowy, or cloudy")
        return
    
    # Agent's rule-based decision making
    recommendation = make_decision(temperature, weather_condition)
    
    # Output response
    weather_emoji = get_weather_emoji(weather_condition)
    print(f"\n{weather_emoji} Weather: {temperature}°C and {weather_condition}")
    print(f"👕 Recommendation: {recommendation}")

def make_decision(temp, condition):
    """
    Rule-based decision making for clothing recommendations
    """
    base_clothing = ""
    
    # Temperature-based clothing rules
    if temp < 10:
        base_clothing = "Wear a heavy coat, warm sweater, long pants, and boots"
    elif temp >= 10 and temp <= 20:
        base_clothing = "Wear a light jacket or sweater with long pants"
    elif temp > 20 and temp <= 30:
        base_clothing = "Wear a t-shirt or light shirt with comfortable pants or shorts"
    else:  # temp > 30
        base_clothing = "Wear light, breathable clothing like shorts and a t-shirt"
    
    # Weather condition modifications
    if condition == "rainy":
        return base_clothing + " with a raincoat or umbrella. Don't forget waterproof shoes!"
    elif condition == "snowy":
        if temp > 0:
            return base_clothing + " with waterproof boots and gloves. Consider a hat!"
        else:
            return "Wear heavy winter gear: insulated coat, warm hat, gloves, scarf, and waterproof boots"
    elif condition == "sunny":
        if temp > 25:
            return base_clothing + ". Don't forget sunglasses and sunscreen!"
        else:
            return base_clothing + ". Perfect weather to enjoy outdoors!"
    else:  # cloudy
        return base_clothing + ". Great weather for outdoor activities!"

def get_weather_emoji(condition):
    """
    Returns appropriate emoji for weather condition
    """
    emojis = {
        "sunny": "☀️",
        "rainy": "🌧️", 
        "snowy": "❄️",
        "cloudy": "☁️"
    }
    return emojis.get(condition, "🌤️")

# Main execution
if __name__ == "__main__":
    while True:
        weather_advisor_agent()
        
        again = input("\nWould you like another recommendation? (y/n): ").lower()
        if again != 'y' and again != 'yes':
            print("👋 Thank you for using Weather Advisor Agent!")
            break
        print("\n" + "="*40 + "\n")