public class MathTest {
    public static void main(String [] args){
        testLog();
    }

    public static void testLog(){
        double value = 101;
        double v = Math.log10(value);
        System.out.println(v);// 2.0
        double result = Math.ceil(v);
        System.out.println(result);// 3.0
    }

    public static void testDits(){
        double d = 12.2324325345345345345;

    }
}
