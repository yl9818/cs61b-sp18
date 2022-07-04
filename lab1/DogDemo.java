public class DogDemo {
    public int weightInPounds;
    public static String binomen = "Canis familiaris";
    
    public DogDemo(int w) {
        weightInPounds = w;
    }

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("barkbark!");
        } else {
            System.out.println("woof!");
        }
    }

    public static DogDemo maxDog(DogDemo d1, DogDemo d2) {
        return (d1.weightInPounds > d2.weightInPounds) ? d1 : d2;
    }

    public DogDemo maxDog(DogDemo d1) {
        return (d1.weightInPounds > this.weightInPounds) ? d1 : this;
    }
}
