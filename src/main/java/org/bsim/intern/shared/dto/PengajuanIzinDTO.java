package org.bsim.intern.shared.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PengajuanIzinDTO implements Serializable {
    private static final long serialVersionUID = 1261755895328547362L;
    private long id;
    private String izinId;
    private LocalDate tanggalMulai;
    private LocalDate tanggalSelesai;
    private String note;
    private boolean isChecked; //is checked

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIzinId() {
        return izinId;
    }

    public void setIzinId(String izinId) {
        this.izinId = izinId;
    }

    public LocalDate getTanggalMulai() { return tanggalMulai; }

    public void setTanggalMulai(LocalDate tanggalMulai) { this.tanggalMulai = tanggalMulai; }

    public LocalDate getTanggalSelesai() { return tanggalSelesai; }

    public void setTanggalSelesai(LocalDate tanggalSelesai) { this.tanggalSelesai = tanggalSelesai; }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
