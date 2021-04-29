package org.bsim.intern.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "absensi_test")
public class AbsensiEntity implements Serializable {
    private static final long serialVersionUID= 7990825441501678936L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String absenid;

    @Column(nullable = false)
    private LocalDateTime clockin;

    @Column(nullable = true)
    private LocalDateTime clockcheck;

    @Column(nullable = true)
    private LocalDateTime clockout;

    @Column(name = "is_checked")
    private boolean isChecked = false;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbsenid() {
        return absenid;
    }

    public void setAbsenid(String absenid) {
        this.absenid = absenid;
    }

    public LocalDateTime getClockin() {
        return clockin;
    }

    public void setClockin(LocalDateTime tanggal) {
        this.clockin = tanggal;
    }

        public LocalDateTime getClockcheck() {
        return clockcheck;
    }

    public void setClockcheck(LocalDateTime clockcheck) {
        this.clockcheck = clockcheck;
    }

    public LocalDateTime getClockout() {
        return clockout;
    }

    public void setClockout(LocalDateTime clockout) {
        this.clockout = clockout;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
