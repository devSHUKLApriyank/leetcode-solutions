public class xy{
    public static void main(String[] args) {
        int x = 2;
        int y = --x + x++ + x--;
        
        System.out.println("y = " + y);
        System.out.println("x = " + x);
    }
}