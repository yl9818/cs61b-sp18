// A client of Dog
// test drive the Dog class
public class DogLauncher {
    public static void main(String[] args) {
        // DogDemo d;
        // d = new DogDemo();
        // OR
        // DogDemo d = new DogDemo();
        // d.weightInPounds = 5;
        //d.makeNoise();

        // DogDemo d = new DogDemo(8);//with constructor
        //d.makeNoise();

        DogDemo[] dogs = new DogDemo[3];
        dogs[0] = new DogDemo(8);
        dogs[1] = new DogDemo(20);
        dogs[2] = new DogDemo(30);
        for (DogDemo d : dogs) {
            d.makeNoise();
        }

        System.out.println(DogDemo.maxDog(dogs[0], dogs[1]));
        System.out.println(dogs[1].maxDog(dogs[2]));

    }
}
