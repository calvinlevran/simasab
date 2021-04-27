package org.bsim.intern.service.iservice;

import org.bsim.intern.shared.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getListUser();
    UserDTO addNewData(UserDTO user);
}
