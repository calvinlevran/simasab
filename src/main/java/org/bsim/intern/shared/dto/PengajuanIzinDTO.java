package org.bsim.intern.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PengajuanIzinDTO implements Serializable {
    private static final long serialVersionUID = 1261755895328547362L;
    private long id;
    private String izinId;
    private LocalDateTime tanggalMulai;
    private LocalDateTime tanggalSelesai;
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

    public LocalDateTime getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDateTime tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public LocalDateTime getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(LocalDateTime tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

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
