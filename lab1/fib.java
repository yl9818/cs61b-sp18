public class fib {
    public static int fib(int n) {
        if (n == 0) return 0;
        int f = 0, g = 1;
        while (--n > 0) {
            g = f + g;
            f = g - f;
        }
        return g;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(fib(n));
    }
}
