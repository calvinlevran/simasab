package org.bsim.intern.service.iservice;

import org.bsim.intern.io.entity.PengajuanIzinEntity;
import org.bsim.intern.shared.dto.PengajuanIzinDTO;

import java.util.List;

public interface IPengajuanIzinService {
    PengajuanIzinDTO addNewPengajuanIzin(String userId, PengajuanIzinDTO izin);
    List<PengajuanIzinDTO> getListIzin(Integer pageNo, Integer pageSize, String sortBy);
    PengajuanIzinDTO updateStatusIzin(String userId, String izinId, PengajuanIzinDTO pengajuanIzinDTO);
    List<PengajuanIzinDTO> getIzinByUserid(String userid);
}
