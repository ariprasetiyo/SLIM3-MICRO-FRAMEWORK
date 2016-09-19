/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import ari.test.controller.operator.IndexController;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ari-prasetiyo
 */
@Ignore("test data kelurahan")
public class KelurahanTest {

    @Test
    public void kelurahanTest() {
        IndexController testFromOperator = new IndexController();
        List<String> dataList = testFromOperator.getKelurahan();
        assertTrue(dataList.size() > 0);
        for (String x : dataList) {
            Logger.getLogger(KelurahanTest.class+"").info("kelurahan :" + x);
        }
    }
}
