public class GuitarHero {
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
//        synthesizer.GuitarString string = new synthesizer.GuitarString(440);
//        synthesizer.Harper string = new synthesizer.Harper(440);
        synthesizer.Drums string = new synthesizer.Drums(440);

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index > -1) {
                    string = new synthesizer.Drums(440 * Math.pow(2,
                            (index - 24) / 12));
                    string.pluck();
                }
            }

            /* compute the superposition of samples */
//            double sample = string.sample() + string.sample();

            /* play the sample on standard audio */
            StdAudio.play(string.sample());

            /* advance the simulation of each guitar string by one step */
            string.tic();
        }
    }
}
