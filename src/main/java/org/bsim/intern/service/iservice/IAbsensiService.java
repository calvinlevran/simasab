package org.bsim.intern.service.iservice;

import org.bsim.intern.shared.dto.AbsensiDTO;

import java.util.List;

public interface IAbsensiService {
    AbsensiDTO addNewClockInData(String userid, AbsensiDTO absensiDTO);
    AbsensiDTO updateAbsensiClockCheck(String userid, String absenid, AbsensiDTO absensiDTO);
    AbsensiDTO updateAbsensiClockOut(String userid, String absenid, AbsensiDTO absensiDTO);
    List<AbsensiDTO> getListAbsensi();

    AbsensiDTO updateStatusAbsen(String userid, String absenid, AbsensiDTO absensiDTO);
    AbsensiDTO getAbsenByUserid(String userid);
}
