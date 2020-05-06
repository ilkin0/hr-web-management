package az.hrm.model;

import java.util.Arrays;

public class DataTableResponse {
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private Object[][] data;

    public DataTableResponse() {
    }

    public int getDraw() {
        return this.draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return this.recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return this.recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Object[][] getData() {
        return this.data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public String toString() {
        int var10000 = this.draw;
        return "DataTableResponse{draw='" + var10000 + "', recordsTotal=" + this.recordsTotal + ", recordsFiltered=" + this.recordsFiltered + ", data=" + Arrays.toString(this.data) + "}";
    }
}

