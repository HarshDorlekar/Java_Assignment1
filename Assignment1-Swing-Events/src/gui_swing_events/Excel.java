package gui_swing_events;
import java.util.ArrayList;

public class Excel {
    public  static double calculateTotal(ArrayList<Double> numbers){
        double total = 0;
        for (double number : numbers){
            total += number;
        }
        return  total;
    }

    public static double calculateAverage(ArrayList<Double> numbers){
        double total = calculateTotal(numbers);
        return total / numbers.size();
    }

    public static double calculateMaximum(ArrayList<Double> numbers){
        double maximum = Double.MIN_VALUE;
        for (double number : numbers){
            if(number > maximum){
                maximum = number;
            }
        }
        return maximum;
    }
    public static double calculateMinimum(ArrayList<Double> numbers){
        double minimum = Double.MAX_VALUE;

        for (double number : numbers){
            if(number < minimum){
                minimum = number;
            }
        }
        return minimum;
    }
}
