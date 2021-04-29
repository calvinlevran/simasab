package org.bsim.intern.io.entity;

import org.bsim.intern.shared.dto.PengajuanIzinDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID= 3582374033754775716L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)", length = 20)
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)", length = 100)
    private String email;

    @Column(nullable = false)
    private String nohp;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)", length = 10)
    private String jabatan;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AbsensiEntity> absensiEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PengajuanIzinEntity> pengajuanIzinEntities = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public List<AbsensiEntity> getAbsensiEntities() {
        return absensiEntities;
    }

    public void setAbsensiEntities(List<AbsensiEntity> absensiEntities) {
        this.absensiEntities = absensiEntities;
    }

    public List<PengajuanIzinEntity> getPengajuanIzinEntities() {
        return pengajuanIzinEntities;
    }

    public void setPengajuanIzinEntities(List<PengajuanIzinEntity> pengajuanIzinEntities) {
        this.pengajuanIzinEntities = pengajuanIzinEntities;
    }

}
