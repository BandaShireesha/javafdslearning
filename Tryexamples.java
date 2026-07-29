public class Tryexamples{
    public static void main(String[] args) {
        try{
            int a = 12;
            int b = 21;
            int c=123;
            System.out.println(c);
        }catch(ArithmeticException e){
            System.out.println( "Cannot divide by zero");
        }
        System.out.println("Programming Continous");
    }
}