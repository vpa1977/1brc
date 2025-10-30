package benchmarks;

import dev.morling.onebrc.CalculateAverage_baseline;

import java.io.PrintStream;

public class Loop_baseline_infinite {
    static PrintStream devNull;
    record Entry(long start, long end){}
    public static void main(String[] args) throws Throwable {
        long start = System.currentTimeMillis();
        long iterStart = start;
        long iterEnd;
        for (int i = 0 ; i < 50; ++i ) {
            iterStart = System.currentTimeMillis();
            CalculateAverage_baseline.main(args);
            iterEnd = System.currentTimeMillis();
            System.out.println( (iterStart - start) + ","+ (iterEnd - iterStart));
        }
        Thread.sleep(500000);
    }
}
