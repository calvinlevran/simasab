package org.bsim.intern.service.impl;

import org.bsim.intern.io.entity.UserEntity;
import org.bsim.intern.io.irepository.UserRepository;
import org.bsim.intern.service.iservice.IUserService;
import org.bsim.intern.shared.dto.UserDTO;
import org.bsim.intern.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public List<UserDTO> getListUser(Integer pageNo, Integer pageSize, String sortBy) {
        List<UserDTO> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        // Get all user from database
        Page<UserEntity> users = userRepository.findAll(paging);
        for(UserEntity userEntity : users){
            value.add(modelMapper.map(userEntity, UserDTO.class));
        }

        return value;
    }

    @Override
    public UserDTO addNewData(UserDTO user) {
        user.setUserId(generateRandomPublicId.generateUserId(30));

        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = modelMapper.map(user,UserEntity.class);
        UserEntity storedData = userRepository.save(userEntity);
        UserDTO value = modelMapper.map(storedData, UserDTO.class);

        return value;
    }
}
