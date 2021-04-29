package org.bsim.intern.ui.model.request;

import java.time.LocalDateTime;

public class AbsensiRequest {
    private LocalDateTime clockin;
    private LocalDateTime clockcheck;
    private LocalDateTime clockout;
    private boolean isChecked;

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

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
