/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ari-prasetiyo
 */
@Ignore
public class AllFlowTest {

    @Test
    public void testDataUserDanGroups() {
        SysUserTest test = new SysUserTest();
        test.createGroupsSample();

        //test.checkJumlahDataGroups();
    }

    @Test
    public void testDataKelurahan() {
//        KelurahanTest test = new KelurahanTest();
//        test.kelurahanTest();
    }

    @Test
    public void insetDataPasien() {
        PasienInsertTest test = new PasienInsertTest();
        test.testInsertPasienDua();
    }

    public void deleteAllDataTest() {
        
    }

}
