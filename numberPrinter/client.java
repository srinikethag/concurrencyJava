package numberPrinter;

public class client {
    public static void main(String[] args) {

        // prints the number from different threads
        for(int i=0; i<100; i++){
            NumberPrinter np = new NumberPrinter(i);

            Thread thread = new Thread(np);
            thread.start();
        }


    }
}
