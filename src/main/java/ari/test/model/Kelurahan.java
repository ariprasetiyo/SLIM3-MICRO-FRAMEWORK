/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ari-prasetiyo
 */
@Entity
@Table(name = "stg_kelurahan")
public class Kelurahan extends ModelEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Column(length = 100)
    private String kelurahan;
    @Column(length = 100)
    private String kecamatan;
    @Column(length = 100)
    private String kota;
   
    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
