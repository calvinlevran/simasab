package org.bsim.intern.ui.controller;

import org.bsim.intern.service.iservice.IUserService;
import org.bsim.intern.shared.dto.UserDTO;
import org.bsim.intern.ui.model.request.UserRequest;
import org.bsim.intern.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserResponse> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNo,
                                          @RequestParam(defaultValue = "5") Integer pageSize,
                                          @RequestParam(defaultValue = "id") String sortBy){
        List<UserDTO> users = userService.getListUser(pageNo, pageSize, sortBy);

        List<UserResponse> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(UserDTO userDTO : users){
            value.add(modelMapper.map(userDTO, UserResponse.class));
        }
        return value;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse addNewUser(@RequestBody UserRequest user){
        ModelMapper modelMapper = new ModelMapper();

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        UserDTO createdUser = userService.addNewData(userDTO);

        UserResponse response = modelMapper.map(createdUser, UserResponse.class);

        return response;
    }
}
