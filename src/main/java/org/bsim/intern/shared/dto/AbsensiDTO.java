package org.bsim.intern.shared.dto;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AbsensiDTO implements Serializable {
    private static final long serialVersionUID= 1744306874344727761L;
    private long id;
    private String absenid;

    public String getAbsenid() {
        return absenid;
    }

    public void setAbsenid(String absenid) {
        this.absenid = absenid;
    }

    private LocalDateTime clockin;
    private LocalDateTime clockcheck;
    private LocalDateTime clockout;
    private boolean isChecked = false;
    private UserDTO userDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getClockin() {
        return clockin;
    }

    public void setClockin(LocalDateTime clockin) {
        this.clockin = clockin;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
