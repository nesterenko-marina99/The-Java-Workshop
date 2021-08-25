import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class SummerHighs {
    Table<String, String, SummerHigh> data;

    public SummerHighs() {
        data = HashBasedTable.create();
    }


}
