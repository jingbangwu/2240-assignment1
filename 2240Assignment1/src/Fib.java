public class Fib {

    public static void main(String[] args) {
        Fib fib = new Fib();
        fib.simulate(10);
        fib.simulate(20);
        fib.simulate(30);
        fib.simulate(40);
        fib.simulate(50);
    }

    public void simulate(int n) {
        System.out.println("Simulate n = " + n);
        // record rec fib
        long recStart = System.nanoTime();
        fiboSeriesRec(n);
        long recEnd = System.nanoTime();
        System.out.println();
        System.out.println("Rec cost time in mills: " + (recEnd - recStart));
        // record ite fib
        long itStart = System.nanoTime();
        fiboSeriesIte(n);
        long itEnd = System.nanoTime();
        System.out.println();
        System.out.println("Ite cost time in mills: " + (itEnd - itStart));
        System.out.println("End simulation");
    }


    public void fiboSeriesRec(int n) {
        for (int i = 1; i <= n; i++) {
            long it = fib(i);
            System.out.print(it + " ");
        }
    }

    private long fib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // do return fib(n) = fib(n-1) + fib(n-2)
        return fib(n - 2) + fib(n - 1);
    }

    public void fiboSeriesIte(int n) {
        long fir = 0;
        long sec = 1;
        // n == 1 no need to ite
        if (n == 1) {
            System.out.print(fir);
            return;
        }
        // output the first two init value
        System.out.print(fir + " " + sec);

        for (int i = 0; i < n - 2; i++) {
            // increase
            long tmp = fir + sec;
            // update args
            fir = sec;
            sec = tmp;
            System.out.print(" " + sec);
        }
    }

}

