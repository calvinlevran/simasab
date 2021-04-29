package org.bsim.intern.io.irepository;

import org.bsim.intern.io.entity.AbsensiEntity;
import org.bsim.intern.io.entity.PengajuanIzinEntity;
import org.bsim.intern.io.entity.UserEntity;
import org.bsim.intern.shared.dto.AbsensiDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsensiRepository extends JpaRepository<AbsensiEntity, Long> {
    AbsensiEntity save(AbsensiEntity absensiEntity);

    AbsensiEntity findByAbsenid(String absenid);
}
