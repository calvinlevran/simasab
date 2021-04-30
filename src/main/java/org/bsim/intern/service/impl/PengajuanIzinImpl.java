package org.bsim.intern.service.impl;

import org.bsim.intern.io.entity.PengajuanIzinEntity;
import org.bsim.intern.io.entity.UserEntity;
import org.bsim.intern.io.irepository.PengajuanIzinRepository;
import org.bsim.intern.io.irepository.UserRepository;
import org.bsim.intern.service.iservice.IPengajuanIzinService;
import org.bsim.intern.shared.dto.PengajuanIzinDTO;
import org.bsim.intern.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PengajuanIzinImpl implements IPengajuanIzinService {
    private final PengajuanIzinRepository pengajuanIzinRepository;
    private final GenerateRandomPublicId generateRandomPublicId;
    private final UserRepository userRepository;

    public PengajuanIzinImpl(PengajuanIzinRepository pengajuanIzinRepository, GenerateRandomPublicId generateRandomPublicId, UserRepository userRepository) {
        this.pengajuanIzinRepository = pengajuanIzinRepository;
        this.generateRandomPublicId = generateRandomPublicId;
        this.userRepository = userRepository;
    }

    @Override
    public PengajuanIzinDTO addNewPengajuanIzin(String userId, PengajuanIzinDTO izin) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = userRepository.findByUserid(userId);

        PengajuanIzinEntity pengajuanIzinEntity = modelMapper.map(izin, PengajuanIzinEntity.class);
        pengajuanIzinEntity.setIzinId(generateRandomPublicId.generatePengajuanIzinId(30));
        pengajuanIzinEntity.setUser(userEntity);
        PengajuanIzinEntity storedData = pengajuanIzinRepository.save(pengajuanIzinEntity);
        PengajuanIzinDTO value = modelMapper.map(storedData, PengajuanIzinDTO.class);
        value.setIzinId(pengajuanIzinEntity.getIzinId());
        return value;
    }

    @Override
    public List<PengajuanIzinDTO> getListIzin(Integer pageNo, Integer pageSize, String sortBy) {
        List<PengajuanIzinDTO> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<PengajuanIzinEntity> izins = pengajuanIzinRepository.findAll(paging);

        for(PengajuanIzinEntity pengajuanIzinEntity : izins){
            value.add(modelMapper.map(pengajuanIzinEntity, PengajuanIzinDTO.class));
        }
        return value;
    }

    @Override
    public PengajuanIzinDTO updateStatusIzin(String userId, String izinId, PengajuanIzinDTO pengajuanIzinDTO) {
        PengajuanIzinEntity pengajuanIzinData = pengajuanIzinRepository.findByIzinId(izinId);

        pengajuanIzinData.setChecked(pengajuanIzinDTO.isChecked());

        PengajuanIzinEntity updateData = pengajuanIzinRepository.save(pengajuanIzinData);
        return new ModelMapper().map(updateData, PengajuanIzinDTO.class);
    }

    @Override
    public List<PengajuanIzinDTO> getIzinByUserid(String userid) {
        List<PengajuanIzinDTO> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = userRepository.findByUserid(userid);
        List<PengajuanIzinEntity> izins = pengajuanIzinRepository.findAllByUser(userEntity);
        for(PengajuanIzinEntity pengajuanIzinEntity : izins){
            value.add(modelMapper.map(pengajuanIzinEntity, PengajuanIzinDTO.class));
        }
        if(izins == null)
            return null;

        return value;
    }

}
