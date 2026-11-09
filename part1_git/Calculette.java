
public class Calculette {

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int soustraction(int a, int b) {
        return a - b ;
    }
    public static int division(int a, int b) {
        return a / b ;
    }

    public static void main(String[] args) {
        System.out.println("1 + 3 = " + addition(1,3));
        System.out.println("3 - 1 = " + soustraction(3,1));
        System.out.println("6 / 2 = " + division(6,2));
    }
}