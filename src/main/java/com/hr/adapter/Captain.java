package com.hr.adapter;

/**
 * @author huran
 * @Title: Captain
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/1516:51
 */
public class Captain {
    private RowingBoat rowingBoat;

    public Captain() {}

    public Captain(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    public void setRowingBoat(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }

    public void row() {
        rowingBoat.row();
    }
}
