package numberPrinterUsingThreadPools;

public class numberPrinterUsingThreadPools implements Runnable{

    private final int number;
    public numberPrinterUsingThreadPools(int number){
        this.number = number;
    }
    @Override
    public void run(){
        System.out.println(this.number + " from thread " + Thread.currentThread().getName());
    }
}
