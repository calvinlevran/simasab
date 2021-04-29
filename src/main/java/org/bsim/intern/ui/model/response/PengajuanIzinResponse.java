package org.bsim.intern.ui.model.response;

import java.time.LocalDateTime;

public class PengajuanIzinResponse {
    private String izinId;
    private LocalDateTime tanggalMulai;
    private LocalDateTime tanggalSelesai;
    private String note;
    private boolean isChecked; //is checked

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

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
