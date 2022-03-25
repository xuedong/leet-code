class ZeroEvenOdd {
    private int n;
    private final Semaphore semaZero;
    private final Semaphore semaOdd;
    private final Semaphore semaEven;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        semaZero = new Semaphore(1);
        semaOdd = new Semaphore(0);
        semaEven = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaEven.release();
            } else {
                semaOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaEven.acquire();
            printNumber.accept(i);
            semaZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            semaOdd.acquire();
            printNumber.accept(i);
            semaZero.release();
        }
    }
}

