package org.bsim.intern.io.entity;

import javax.persistence.*;
import java.io.Serializable;

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
}
