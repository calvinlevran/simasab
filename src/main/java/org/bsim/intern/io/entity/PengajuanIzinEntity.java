package org.bsim.intern.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "PengajuanIzin")
public class PengajuanIzinEntity implements Serializable {

    private static final long serialVersionUID = 7129543651868406020L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String izinId;

    @Column(nullable = false)
    private LocalDate tanggalMulai;

    @Column(nullable = false)
    private LocalDate tanggalSelesai;

    @Column(nullable = false)
    private String note;

    private boolean isChecked = false;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity user;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
