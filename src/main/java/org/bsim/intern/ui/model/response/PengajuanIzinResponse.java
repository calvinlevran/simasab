package org.bsim.intern.ui.model.response;

import java.time.LocalDate;

public class PengajuanIzinResponse {
    private String izinId;
    private LocalDate tanggalMulai;
    private LocalDate tanggalSelesai;
    private String note;
    private boolean isChecked; //is checked

    public String getIzinId() {
        return izinId;
    }

    public void setIzinId(String izinId) {
        this.izinId = izinId;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(LocalDate tanggalSelesai) {
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
