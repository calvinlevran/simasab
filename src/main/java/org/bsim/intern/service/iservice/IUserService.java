package org.bsim.intern.service.iservice;

import org.bsim.intern.shared.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getListUser(Integer pageNo, Integer pageSize, String sortBy);
    UserDTO addNewData(UserDTO user);
}
