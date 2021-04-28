package org.bsim.intern.io.irepository;

import org.bsim.intern.io.entity.PengajuanIzinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PengajuanIzinRepository extends JpaRepository<PengajuanIzinEntity, Long> {
    PengajuanIzinEntity save(PengajuanIzinEntity pengajuanIzinEntity);
    List<PengajuanIzinEntity> findAll();
    PengajuanIzinEntity findByIzinId(String izinId);
}
