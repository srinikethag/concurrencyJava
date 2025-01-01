package helloWorldPrinter;

public class client {
    public static void main(String[] args) {
        HelloWorldPrinter hw = new HelloWorldPrinter();

        // print hello world from different threads
        for(int i=0; i<50; i++){
            Thread thread = new Thread(hw);
            thread.start();
        }

    }
}
