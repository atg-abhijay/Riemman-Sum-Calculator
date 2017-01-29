import java.util.Scanner;

public class RiemmanSum {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Scanner keyboard = new Scanner(System.in);
  	System.out.println("How many rectangles do you want to use?");
    int rectangles = scan.nextInt();
    System.out.println("Do you want to calculate using the left endpoints, right endpoints, or center endpoints? Type in 'Left', 'Center', or 'Right'.");
    String input = keyboard.nextLine();
    System.out.println("Lower Bound:");
    double lower_bound = scan.nextDouble();
    System.out.println("Upper Bound:");
    double upper_bound = scan.nextDouble();
    System.out.println("Please enter the degree of the polynomial");
    int numParameters = scan.nextInt() + 1;
    double[] parameters = function(numParameters);
    double rSum = calculateRiemmanSum(lower_bound, upper_bound, rectangles, parameters);
    System.out.println("Riemman Sum: " + rSum);
    
  }
  
  public static double calculateRiemmanSum(double leftEnd, double rightEnd, int rectangles, double[] parameters) {
  	double width = (rightEnd - leftEnd)/rectangles;
    double sum = 0;
    for(int i = 0; i < rectangles; i++) {
      double x = leftEnd + (i+1)*width;
      double funcVal = 0;
      for(int j = 0; j < parameters.length; j++) {
      	funcVal += parameters[j] * Math.pow(x, parameters.length - 1 - j);
      }
      sum += funcVal * width; 
    }
    return sum;
  }
  
  public static double[] function(int numParameters) {
    double[] parameters = new double[numParameters];
    Scanner reader = new Scanner(System.in);
    System.out.println("Please enter the coefficients for the function");
    for(int i = 0; i < parameters.length; i++) {
    	parameters[i] = reader.nextDouble();
        //System.out.println(parameters[i]);
    }
    return parameters;
  }
}