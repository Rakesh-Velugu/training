import java.util.Comparator;

public class ValueRank {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    private int value;
   private  int rank;
    public ValueRank(int a, int b){
        this.rank=b;
        this.value =a;
    }
}