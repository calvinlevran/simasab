package org.bsim.intern.io.irepository;

import org.bsim.intern.io.entity.AbsensiEntity;
import org.bsim.intern.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsensiRepository extends JpaRepository<AbsensiEntity, Long> {
    AbsensiEntity save(AbsensiEntity absensiEntity);

    AbsensiEntity findByAbsenid(String absenid);

    AbsensiEntity findByUserEntity(UserEntity userEntity);
}
