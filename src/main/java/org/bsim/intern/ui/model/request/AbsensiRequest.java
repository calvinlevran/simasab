package org.bsim.intern.ui.model.request;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AbsensiRequest {
    private LocalDateTime clockin;
    private LocalDateTime clockcheck;
    private LocalDateTime clockout;

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
}
