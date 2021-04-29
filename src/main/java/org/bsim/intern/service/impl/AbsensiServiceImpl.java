package org.bsim.intern.service.impl;

import org.bsim.intern.io.entity.AbsensiEntity;
import org.bsim.intern.io.entity.UserEntity;
import org.bsim.intern.io.irepository.AbsensiRepository;
import org.bsim.intern.io.irepository.UserRepository;
import org.bsim.intern.service.iservice.IAbsensiService;
import org.bsim.intern.shared.dto.AbsensiDTO;
import org.bsim.intern.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbsensiServiceImpl implements IAbsensiService {

    private final AbsensiRepository absensiRepository;
    private final GenerateRandomPublicId generateRandomPublicId;
    private final UserRepository userRepository;

    public AbsensiServiceImpl(AbsensiRepository absensiRepository, GenerateRandomPublicId generateRandomPublicId, UserRepository userRepository) {
        this.absensiRepository = absensiRepository;
        this.generateRandomPublicId = generateRandomPublicId;
        this.userRepository = userRepository;
    }

    @Override
    public AbsensiDTO addNewClockInData(String userid, AbsensiDTO absensiDTO) {
        ModelMapper modelMapper = new ModelMapper();
        //check user
        UserEntity userEntity = userRepository.findByUserid(userid);

        AbsensiEntity absensiEntity = modelMapper.map(absensiDTO, AbsensiEntity.class);
        absensiEntity.setAbsenid(generateRandomPublicId.generateUserId(30));
        // set user
        absensiEntity.setUserEntity(userEntity);

        // save data to database
        AbsensiEntity storedData = absensiRepository.save(absensiEntity);
        AbsensiDTO returnValue = modelMapper.map(storedData, AbsensiDTO.class);

        returnValue.setAbsenid(absensiEntity.getAbsenid());

        return returnValue;
    }

    @Override
    public AbsensiDTO updateAbsensiClockCheck(String userid, String absenid, AbsensiDTO absensiDTO) {
        AbsensiEntity absensiEntity = absensiRepository.findByAbsenid(absenid);

        ModelMapper modelMapper = new ModelMapper();
        absensiEntity.setClockcheck(absensiDTO.getClockcheck());

        AbsensiEntity storedData = absensiRepository.save(absensiEntity);
        AbsensiDTO returnValue = modelMapper.map(storedData, AbsensiDTO.class);

        return returnValue;
    }

    @Override
    public AbsensiDTO updateAbsensiClockOut(String userid, String absenid, AbsensiDTO absensiDTO) {

        AbsensiEntity absensiEntity = absensiRepository.findByAbsenid(absenid);

        ModelMapper modelMapper = new ModelMapper();
        absensiEntity.setClockout(absensiDTO.getClockout());

        AbsensiEntity storedData = absensiRepository.save(absensiEntity);
        AbsensiDTO returnValue = modelMapper.map(storedData, AbsensiDTO.class);

        return returnValue;
    }

    @Override
    public List<AbsensiDTO> getListAbsensi() {
        List<AbsensiDTO> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        // Get absensi from database
        List<AbsensiEntity> absens = absensiRepository.findAll();
        for(AbsensiEntity absensiEntity : absens){
            value.add(modelMapper.map(absensiEntity, AbsensiDTO.class));
        }

        return value;
    }

    @Override
    public AbsensiDTO updateStatusAbsen(String userid, String absenid, AbsensiDTO absensiDTO) {
        AbsensiEntity absensiData = absensiRepository.findByAbsenid(absenid);

        ModelMapper mapper = new ModelMapper();
        absensiData.setChecked(absensiDTO.isChecked());

        AbsensiEntity updateData = absensiRepository.save(absensiData);
        return new ModelMapper().map(updateData, AbsensiDTO.class);
    }

    @Override
    public List<AbsensiDTO> getAbsensiByUserid(String userid) {
        List<AbsensiDTO> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = userRepository.findByUserid(userid);
        List<AbsensiEntity> absens = absensiRepository.findAllByUserEntity(userEntity);
        for(AbsensiEntity absensiEntity : absens){
            value.add(modelMapper.map(absensiEntity, AbsensiDTO.class));
        }
        if(absens == null)
            return null;
        return value;
    }

}
