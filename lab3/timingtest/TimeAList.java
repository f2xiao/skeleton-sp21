package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

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

    public static AList<Integer> createNs(int n0, int numOfTests){
        AList<Integer> Ns = new AList<>();
        for (int i = 0; i < numOfTests; i++) {
            Ns.addLast((int) (n0 * Math.pow(2,i)));
        }

        return Ns;
    }

    public static Double calcTime(int size){
        AList<Integer> list = new AList<>();
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < size; i++) {
            list.addLast(i);
        }
        return sw.elapsedTime();
    }

    public static AList<Double> createTimes(AList<Integer> Ns){
        AList<Double> times = new AList<>();
        for (int i = 0; i <Ns.size() ; i++) {
            times.addLast(calcTime(Ns.get(i)));
        }
        return times;
    }
    public static AList<Integer> copyNs(AList<Integer> Ns){
        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i <Ns.size() ; i++) {
            opCounts.addLast(Ns.get(i));
        }

        return opCounts;
    }

    public static void timeAListConstruction() {
        int n0 = 1000;
        int numOfTests = 8;
        AList<Integer> Ns = createNs(n0,numOfTests);
        AList<Double> times = createTimes(Ns);
        AList<Integer> opCounts = copyNs(Ns);
        printTimingTable(Ns,times,opCounts);
    }
}
