package numberPrinter;

public class NumberPrinter implements Runnable{

    private final int number;

    public NumberPrinter(int number){
        this.number = number;
    }

    @Override
    public void run(){
        System.out.println("Number is : " + this.number + " : " + Thread.currentThread().getName());
    }
}
