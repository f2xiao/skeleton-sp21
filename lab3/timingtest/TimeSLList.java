package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static AList<Double> createTimes(AList<Integer> Ns, int M){
        AList<Double> times = new AList<>();
        for (int i = 0; i <Ns.size() ; i++) {
            times.addLast(calcTime(Ns.get(i), M));
        }
        return times;
    }
    public static Double calcTime(int size,int M){
        SLList<Integer> list = new SLList<>();
        for (int i = 0; i < size; i++) {
            list.addLast(i);
        }
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < M; i++) {
            list.getLast();
        }
        return sw.elapsedTime();
    }
    public static AList<Integer> createCounts(int numOfTests, int M){
        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i < numOfTests; i++) {
            opCounts.addLast(M);
        }
        return opCounts;
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int n0 = 1000;
        int numOfTests = 8;
        int M = 10000;
        AList<Integer> Ns = TimeAList.createNs(n0,numOfTests);
        AList<Double> times = createTimes(Ns, M);
        AList<Integer> opCounts = createCounts(numOfTests,M);
        printTimingTable(Ns,times,opCounts);
    }

}
