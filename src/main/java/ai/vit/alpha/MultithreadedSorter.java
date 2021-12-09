package ai.vit.alpha;

import java.util.*;
import java.util.concurrent.*;

public class MultithreadedSorter extends RecursiveAction
{
    private final List<String> data;
    private final int start;
    private final int end;
    private final StringComparator comparator = new StringComparator();

    private class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] o1Split = o1.split("@");
            String[] o2Split = o2.split("@");
            if (o1Split.length != 2 || o2Split.length != 2) {
                return o1.compareTo(o2);
            }
            if (o1Split[1].compareTo(o2Split[1]) == 0) {
                return o1Split[0].compareTo(o2Split[0]);
            }
            return o1Split[1].compareTo(o2Split[1]);
        }
    }

    public static void sort(List<String> data) {
        ForkJoinPool pool = new ForkJoinPool();
        MultithreadedSorter task = new MultithreadedSorter(data, 0, data.size());
        pool.invoke(task);
    }

    private MultithreadedSorter (List<String> data, int start, int end)
    {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute()
    {
        if ((end - start) >= 2) {
            int mid = (end - start) / 2 + start;
            MultithreadedSorter firstHalf = new MultithreadedSorter(data, start, mid);
            MultithreadedSorter secondHalf = new MultithreadedSorter(data, mid, end);
            firstHalf.fork();
            secondHalf.fork();
            firstHalf.join();
            secondHalf.join();
            merge(start, mid, end);
        }
    }

    private List<String> merge(int start, int mid, int end)
    {
        int i=start, j=mid;
        List<String> result = new ArrayList<>(end - start);

        while(i < mid && j < end)
            result.add((comparator.compare(data.get(i), data.get(j)) < 0) ? data.get(i++): data.get(j++));

        while(i < mid) result.add(data.get(i++));

        while(j < end) result.add(data.get(j++));

        for (int k = 0; k < result.size(); k++) {
            data.set(start + k, result.get(k));
        }

        return result;
    }
}
