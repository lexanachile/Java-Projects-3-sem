public class ExArray {
    private double x;
    private int precision;

    public ExArray(double x, int precision) {
        this.x = x;
        this.precision = precision;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setPrecision(int precision){
        this.precision = precision;
    }
    public double calculateEx() {
        double epsilon = Math.pow(10, -precision)/100;
        double term = 1.0;
        double sum = 0.0;
        int index = 1;
        while (Math.abs(term) >= epsilon) {
            sum += term;
            term = term * x / index++;
        }
        return sum;
    }
    public double calculateSinX() {
        double epsilon = Math.pow(10, -precision);
        double term = x;
        double sum = 0.0;
        int index = 1;
        while (Math.abs(term) >= epsilon) {
            sum += term;
            term *= -1 * x * x / ((2 * index) * (2 * index + 1));
            index++;
        }
        return sum;
    }
}