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

    public static void timeAListConstruction() {
        int n0 = 1000;
        int numOfTests = 8;
        // create Ns
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        // create opCounts
        for (int i = 0; i < numOfTests; i++) {
            Ns.addLast((int) (n0 * Math.pow(2,i)));
        }
        // create times and opCounts
        for (int i = 0; i <Ns.size() ; i++) {
            int size = Ns.get(i);
            opCounts.addLast(size);
            AList<Integer> list = new AList<>();
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < size; j++) {
                list.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        printTimingTable(Ns,times,opCounts);
    }
}
