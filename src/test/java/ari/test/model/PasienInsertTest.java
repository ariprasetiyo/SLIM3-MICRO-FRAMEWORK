/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import ari.test.ref.JenisKelamin;
import ari.test.service.GenerateIdPasienService;
import ari.test.service.DoSaveService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author ari-prasetiyo
 */
@Ignore("untuk test insert data pasien")
public class PasienInsertTest {

    @Ignore
    @Test
    public void testInsertPasien() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DATE, 31);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.YEAR, 1992);

        Pasien dataPasien = new Pasien();
        dataPasien.setIdPasien(new GenerateIdPasienService().doGenerate());
        dataPasien.setNama("Ari P");
        dataPasien.setNoHp("0856");
        dataPasien.setRt(1);
        dataPasien.setRw(2);
        dataPasien.setKelurahan("Beji");
        dataPasien.setTanggalLahir(cal.getTime());
        dataPasien.setJenisKelamin(JenisKelamin.Laki);
        dataPasien.setAlamat("Polman, Beji, Pedan, Klaten");

        DoSaveService sav = new DoSaveService();
        sav.doSave(dataPasien);
    }

    @Test
    public void testInsertPasienDua() {
        Pasien saveData = new Pasien();
        saveData.setIdPasien(new GenerateIdPasienService().doGenerate());
        saveData.setNama("ari");
        saveData.setJenisKelamin(
                ("0").equals("0") ? JenisKelamin.Laki : JenisKelamin.Perempuan);
        saveData.setKelurahan("kelurahan");
        saveData.setNoHp("0976");
        saveData.setAlamat("alamat");
        saveData.setRt(Integer.valueOf("01"));
        saveData.setRw(Integer.valueOf("03"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateLahir = null;
        try {
            dateLahir = dateFormat.parse("31/01/1992");
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String d = dateFormat.format(dateLahir);
            saveData.setTanggalLahir(dateFormat.parse(d));
        } catch (ParseException ex) {
            Logger.getLogger(PasienInsertTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        DoSaveService sav = new DoSaveService();
        assertTrue(sav.doSaveTest(saveData));
    }
}
