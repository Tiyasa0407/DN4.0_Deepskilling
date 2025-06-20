
public class SingletonPatternExample
{

    // Singleton Logger class
    static class Logger
    {
        // Create a private static instance
        private static Logger instance;

        // Make the constructor private
        private Logger()
        {
            System.out.println("Logger instance created.");
        }

        // Provide a public static method to get the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // A simple logging method
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

   
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton verified).");
        } else {
            System.out.println("Different instances exist (Singleton failed).");
        }
    }
}
