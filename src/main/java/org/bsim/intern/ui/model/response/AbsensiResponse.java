package org.bsim.intern.ui.model.response;

import java.time.LocalDateTime;

public class AbsensiResponse {
    private String absenid;
    private LocalDateTime clockin;
    private LocalDateTime clockcheck;
    private LocalDateTime clockout;
    private boolean isChecked = false;

    public String getAbsenid() {
        return absenid;
    }

    public void setAbsenid(String absenid) {
        this.absenid = absenid;
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
}
