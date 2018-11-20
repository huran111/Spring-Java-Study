package com.hr.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huran
 * @Title: FishingBoat
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/1516:53
 */
public class FishingBoat {
    private static final Logger LOGGER = LoggerFactory.getLogger(FishingBoat.class);

    public void sail() {
        LOGGER.info("The fishing boat is sailing");
    }
}
