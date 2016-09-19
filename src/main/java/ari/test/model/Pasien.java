/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import ari.test.ref.JenisKelamin;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ari-prasetiyo
 */
@Entity
@Table(name = "stg_pasien")
public class Pasien extends ModelEntity {

    //private static final long serialVersionUID = 1L;
    //@GenericGenerator(name = "sequence_id", strategy = "ari.test.service.GenerateIdPasien")
    @Column(name = "id_pasien", length = 10)

    private String idPasien;

    @Column(length = 100, nullable = false)
    private String nama;

    private String alamat;

    @Column(length = 100, nullable = false)
    private String kelurahan;

    @NotNull
    private Integer rt;

    @NotNull
    private Integer rw;

    //String karena no hp depan pake nol
    @Column(name = "no_hp", length = 13)
    private String noHp;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;
    
    @Column(name = "jenis_kelamin")
    private JenisKelamin jenisKelamin;

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Integer getRt() {
        return rt;
    }

    public void setRt(Integer rt) {
        this.rt = rt;
    }

    public Integer getRw() {
        return rw;
    }

    public void setRw(Integer rw) {
        this.rw = rw;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

}
