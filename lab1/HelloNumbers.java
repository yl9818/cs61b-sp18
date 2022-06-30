public class HelloNumbers {
    public static void main(String[] args){
        int x = 0;
        for (int i=0;i<10;i++){
            x += i;
            System.out.println(x);
        }
//        System.out.println(5+"horse");
    }
}

// All variables and expression have a so-called static type
// Java variables can contain values of that type, and only that type
// The type of a variable can never change
// Java compiler performs a static type check
