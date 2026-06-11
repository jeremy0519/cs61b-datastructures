package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    private static double getTime(int n) {
        AList<Integer> myAList = new AList<>();
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < n; i++) {
            myAList.addLast(0);
        }
        return sw.elapsedTime();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        for (int n = 1000; n <= 128000; n *= 2) {
            Ns.addLast(n);
        }
        AList<Double> times = new AList<>();
        for (int n = 1000; n <= 128000; n *= 2) {
            times.addLast(getTime(n));
        }
        printTimingTable(Ns, times, Ns);
    }
}
