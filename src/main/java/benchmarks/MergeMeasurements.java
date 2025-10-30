package benchmarks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MergeMeasurements {

    private record Entry(int y1, int y2) {}

    public static void main(String[] a) throws IOException {
        HashMap<Integer, Entry> entries = new HashMap<>();
        String line;
        try (var reader = new BufferedReader(new FileReader("measurements2.csv"))) {
            while ((line = reader.readLine()) != null) {
                String[] args = line.split("\t");
                int x0 = Integer.parseInt(args[0]);
                int y0 = Integer.parseInt(args[1]);
                int x1 = Integer.parseInt(args[2]);
                int y1 = Integer.parseInt(args[3]);
                Entry e = entries.get(x0);
                if (e == null) {
                    entries.put(x0, new Entry(y0, -1));
                } else {
                    entries.put(x0, new Entry(y0, y1));
                }
                e = entries.get(x1);
                if (e == null) {
                    entries.put(x1, new Entry(-1, y1));
                } else {
                    entries.put(x1, new Entry(y0, y1));
                }
            }
        }
        Integer[] arr = entries.keySet().toArray(Integer[]::new);
        Arrays.sort(arr);
        for (int val : arr) {
            Entry e = entries.get(val);
            System.out.print(val+ ",");
            if (e.y1 >= 0) {
                System.out.print(e.y1);
            }
            System.out.print(",");
            if (e.y2 >= 0) {
                System.out.print(e.y2);
            }
            System.out.println();
        }
    }
}
