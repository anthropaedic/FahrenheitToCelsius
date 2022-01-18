// Example F to C in Java
// This file must be named FahrenheitToCelsius.java 
import java.util.Scanner;

public class FahrenheitToCelsius {

    // Constant Variables
    public static final double LOW_TEMP_F_WARNING = 0.0;
    public static final double HIGH_TEMP_F_WARNING = 100.0;
    public static final int MAX_LOOP = 5;

    // Scanner to read inputs in from user
    private static final Scanner scanner = new Scanner(System.in);

    // Main Method - this method is the "main" entry point into the program
    public static void main(String[] args)
    {
        // Initialize Fahrenheit and Celsius variables to zero. 
        Double fahrenheit = Double.valueOf(0);
        Double celsius = Double.valueOf(0);

        // Loop from 0 to MAX_LOOP times
        for(int i=0; i < MAX_LOOP; i++)
        {
            // Ask user for a temperature in Fahrenheit
            writeEmptyLineToConsole();
            writeTextToConsole("Enter a temperature in Fahrenheit: ");

            // Set fahrenheit variable to value user entered
            fahrenheit = getUserInput();
            celsius = calculateCelsius(fahrenheit);

            // If calculation is successful then write it to console
            if(celsius != null)
            {
                checkForTemperatureWarnings(fahrenheit);
                writeTextToConsole("The temperature in Celsius is: " + celsius);
                writeEmptyLineToConsole();
            }
        }
    }

    private static Double getUserInput()
    {
        Double userInput = null;

        // Try to get user input if it's a number
        try
        {
            userInput = Double.valueOf(scanner.next());
        }

        // Handle (catch) the error
        catch (NumberFormatException exception)
        {
            writeErrorToConsole("Data entry error - try again");
            writeEmptyLineToConsole();
        }

        return userInput;
    }

    private static void writeTextToConsole(String text)
    {
        System.out.print(text);
    }

    private static void writeErrorToConsole(String text)
    {
        System.err.println(text);
    }

    private static void writeEmptyLineToConsole()
    {
        System.out.println();
    }

    private static Double calculateCelsius(Double fahrenheit)
    {
        if(fahrenheit != null)
        {
            return ( fahrenheit - 32 ) * 5/9;
        }

        writeErrorToConsole("Error calculating temperature");
        writeEmptyLineToConsole();

        return null;
    }

    private static void checkForTemperatureWarnings(Double fahrenheit)
    {
        // Check for high temperature and issue a warning if necessary
        if(fahrenheit > HIGH_TEMP_F_WARNING)
        {
            writeTextToConsole("Remember to hydrate");
            writeEmptyLineToConsole();
        }

        // Check for low temperature and issue a warning if necessary
        else if(fahrenheit < LOW_TEMP_F_WARNING )
        {
            writeTextToConsole("Remember to pack Long underwear");
            writeEmptyLineToConsole();
        }
    }


    /***********************************************************************
     *                      Unimplemented methods
     ***********************************************************************/
    private static Double calculateFahrenheit(Double celsius)
    {
        throw new UnsupportedOperationException("Method is not implemented.");
    }
}