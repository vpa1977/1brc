package benchmarks;

import dev.morling.onebrc.CalculateAverage_baseline;
import dev.morling.onebrc.CalculateAverage_thomaswue;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Loop_best {
    record Entry(long start, long end){}
    public static void main(String[] args) throws Throwable {
        PrintStream ps = System.out;
        System.setOut(new PrintStream(new FileOutputStream("/dev/null")));
        long start = System.currentTimeMillis();
        long iterStart = start;
        long iterEnd;
        ArrayList<Entry> results = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            iterStart = System.currentTimeMillis();
            CalculateAverage_thomaswue.main(args);
            iterEnd = System.currentTimeMillis();
            results.add(new Entry(iterStart, iterEnd));
        }
        System.setOut(ps);
        for (Entry e : results) {
            System.out.println( (e.start - start) + ","+ (e.end - e.start));
        }
    }
}
