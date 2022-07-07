

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PriorityQueueRunner {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Integer>  values= new ArrayList<>();
        List<ValueRank> valueRankList = new ArrayList<>();
        System.out.println("enter the integers");
        int control;
        do {
            control = sc.nextInt();
            if (control != -1) {
                values.add(control);
                valueRankList.add(new ValueRank(control, 0));
            }
        } while (control != -1);
        PriorityQueue<ValueRank> valueRanks = new PriorityQueue<>(Comparator.comparingInt(ValueRank::getValue));
        List<ValueRank> modifiedValueRank = new ArrayList<>();
        valueRanks.addAll(valueRankList);
        AtomicInteger index = new AtomicInteger(1);
        while (!valueRanks.isEmpty()) {
           int sortedValue = valueRanks.poll().getValue();
           AtomicBoolean found = new AtomicBoolean(false);
           values.forEach(value -> {
               if (value == sortedValue && !found.get()) {
                   found.set(true);
                   if (!valueRankExists(modifiedValueRank, sortedValue)) {
                       modifiedValueRank.add(new ValueRank(value, index.getAndIncrement()));
                   } else {
                       modifiedValueRank.add(new ValueRank(value, getIndex(modifiedValueRank, value)));
                   }
               }
           });
        }
        modifiedValueRank.forEach(valueRank -> System.out.println("For Value: " + valueRank.getValue() + " Rank is: " + valueRank.getRank()));
    }

    private static int getIndex(List<ValueRank> modifiedValueRank, Integer value) {
        AtomicInteger rank = new AtomicInteger();
        modifiedValueRank.forEach(valueRank -> {
            if (valueRank.getValue() == value) {
                rank.set(valueRank.getRank());
            }
        });
        return rank.get();
    }

    private static boolean valueRankExists(List<ValueRank> modifiedValueRank, int sortedValue) {
       AtomicReference<Boolean> isFound = new AtomicReference<>(Boolean.FALSE);
        modifiedValueRank.forEach(valueRank ->
        {
            if (valueRank.getValue() == sortedValue) {
                isFound.set(Boolean.TRUE);
            }
        });
       return isFound.get();
    }

}
