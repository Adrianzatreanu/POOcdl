// clasa de rulat pentru test
public class Test {

    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(12, 5);
        ComplexOperations co = new ComplexOperations();
        Complex c3;
        c3 = co.addTwoComplexNumbers(c1, c2);
        System.out.println(c3); // should print "15 + 9i"
    }
}
