package com.hr.adapter;

/**
 * @author huran
 * @Title: FishingBoatAdapter
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/1516:54
 */
public class FishingBoatAdapter implements RowingBoat {
    FishingBoat fishingBoat;
    public FishingBoatAdapter() {
        fishingBoat = new FishingBoat();
    }

    @Override
    public void row() {
        fishingBoat.sail();
    }
}
