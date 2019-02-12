package unindra.pemrograman.model;

import java.util.Date;


public class JadwalMengajarModel {
    private String idMengajar;
    private Date hari;
    private Double jam;
    private String kelas;
    private Date createdDate;
    private Date updatedDate;

    public String getIdMengajar() {
        return idMengajar;
    }

    public void setIdMengajar(String idMengajar) {
        this.idMengajar = idMengajar;
    }

    public Date getHari() {
        return hari;
    }

    public void setHari(Date hari) {
        this.hari = hari;
    }

    public Double getJam() {
        return jam;
    }

    public void setJam(Double jam) {
        this.jam = jam;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
