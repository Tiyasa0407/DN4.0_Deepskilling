public class FinancialForecast {

    // Step 1: Recursive approach to calculate future value
    // FV(n) = FV(n-1) * (1 + rate), with FV(0) = initial
    public static double forecastRecursive(double initial, double rate, int years) {
        if (years == 0)
            return initial; // Base case
        return forecastRecursive(initial, rate, years - 1) * (1 + rate);
    }

    // Step 2: Iterative optimization 
    public static double forecastIterative(double initial, double rate, int years) {
        double result = initial;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }

    // Step 3: Memoization for variable past growth rates
    public static double forecastMemoized(double initial, double[] growthRates, int year, Double[] memo) {
        if (year == 0) return initial;
        if (memo[year] != null) return memo[year];

        memo[year] = forecastMemoized(initial, growthRates, year - 1, memo) * (1 + growthRates[year - 1]);
        return memo[year];
    }

    // Step 4: Main method with all variants tested
    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double fixedAnnualGrowthRate = 0.08;
        int forecastYears = 5;

        System.out.println(" Financial Forecasting ");

        // Recursive result
        double recursiveResult = forecastRecursive(initialInvestment, fixedAnnualGrowthRate, forecastYears);
        System.out.printf("Recursive Result (Fixed 8%% growth, %d years): %.2f\n", forecastYears, recursiveResult);

        // Iterative optimized result
        double iterativeResult = forecastIterative(initialInvestment, fixedAnnualGrowthRate, forecastYears);
        System.out.printf("Iterative Result (Fixed 8%% growth, %d years): %.2f\n", forecastYears, iterativeResult);

        // Memoized result (for varying rates per year)
        double[] variableGrowthRates = {0.08, 0.06, 0.07, 0.05, 0.09}; // different growth per year
        Double[] memo = new Double[forecastYears + 1];
        double memoizedResult = forecastMemoized(initialInvestment, variableGrowthRates, forecastYears, memo);
        System.out.printf("Memoized Result (Variable growth, %d years): %.2f\n", forecastYears, memoizedResult);

    }
}
