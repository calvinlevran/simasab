package org.bsim.intern.io.irepository;

import org.bsim.intern.io.entity.PengajuanIzinEntity;
import org.bsim.intern.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PengajuanIzinRepository extends JpaRepository<PengajuanIzinEntity, Long>{
    PengajuanIzinEntity save(PengajuanIzinEntity pengajuanIzinEntity);
    PengajuanIzinEntity findByIzinId(String izinId);
    List<PengajuanIzinEntity> findAllByUser(UserEntity userEntity);

}
