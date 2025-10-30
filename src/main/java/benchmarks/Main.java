package benchmarks;

import dev.morling.onebrc.CalculateAverage_baseline;
import dev.morling.onebrc.CalculateAverage_thomaswue;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, time = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Main {

    private PrintStream devNull;
    private PrintStream normal;

    public Main() {
        try {
            devNull = new PrintStream(new FileOutputStream("/dev/null"));
            normal = System.out;
        }
        catch (Exception e) {
        }

    }

    @Benchmark
    public void baselineResult() throws Throwable {
        System.setOut(devNull);
        CalculateAverage_baseline.main(new String[]{});
        System.setOut(normal);
    }

    @Benchmark
    public void thomaswueResult() throws Throwable {
        System.setOut(devNull);
        CalculateAverage_thomaswue.main(new String[]{});
        System.setOut(normal);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Main.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
