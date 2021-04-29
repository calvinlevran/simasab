package org.bsim.intern.ui.controller;

import org.bsim.intern.service.iservice.IAbsensiService;
import org.bsim.intern.shared.dto.AbsensiDTO;
import org.bsim.intern.ui.model.request.AbsensiRequest;
import org.bsim.intern.ui.model.response.AbsensiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/absensi")
public class AbsensiController {

    @Autowired
    IAbsensiService iAbsensiService;

    @PostMapping(path = "/{userid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AbsensiResponse addNewClockIn(@PathVariable String userid, @RequestBody AbsensiRequest clockIn){
        ModelMapper modelMapper = new ModelMapper();

        // nampung request
        AbsensiDTO absensiDTO = modelMapper.map(clockIn, AbsensiDTO.class);
        AbsensiDTO createdAbsenIn = iAbsensiService.addNewClockInData(userid, absensiDTO);

        AbsensiResponse absensiResponse = modelMapper.map(createdAbsenIn, AbsensiResponse.class);

        return absensiResponse;
    }

    @PutMapping(path = "/clockcheck/{userid}/{absenid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AbsensiResponse updateClockCheck (@PathVariable String userid,
                                             @PathVariable String absenid,
                                             @RequestBody AbsensiRequest clockCheck){

        ModelMapper modelMapper = new ModelMapper();

        AbsensiDTO absensiDTO = modelMapper.map(clockCheck, AbsensiDTO.class);
        AbsensiDTO updateClock = iAbsensiService.updateAbsensiClockCheck(userid, absenid, absensiDTO);

        AbsensiResponse absensiResponse = modelMapper.map(updateClock, AbsensiResponse.class);

        return absensiResponse;
    }

    @PutMapping(path = "/clockout/{userid}/{absenid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AbsensiResponse updateClockOut (@PathVariable String userid,
                                             @PathVariable String absenid,
                                             @RequestBody AbsensiRequest clockOut){

        ModelMapper modelMapper = new ModelMapper();

        AbsensiDTO absensiDTO = modelMapper.map(clockOut, AbsensiDTO.class);
        AbsensiDTO updateClockOut = iAbsensiService.updateAbsensiClockOut(userid, absenid, absensiDTO);

        AbsensiResponse absensiResponse = modelMapper.map(updateClockOut, AbsensiResponse.class);

        return absensiResponse;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AbsensiResponse> getAllAbsen(){
        List<AbsensiDTO> absens = iAbsensiService.getListAbsensi();

        List<AbsensiResponse> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(AbsensiDTO absensiDTO : absens){
            value.add(modelMapper.map(absensiDTO, AbsensiResponse.class));
        }
        return value;
    }

    @PutMapping(path = "/{userid}/{absenid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public AbsensiResponse updateStatusAbsen(@PathVariable String userid,
                                                  @PathVariable String absenid,
                                                  @RequestBody AbsensiRequest absensiRequest){
        ModelMapper mapper = new ModelMapper();

        AbsensiDTO absensiDTO = mapper.map(absensiRequest, AbsensiDTO.class);
        AbsensiDTO updateStatus = iAbsensiService.updateStatusAbsen(userid, absenid, absensiDTO);
        return mapper.map(updateStatus, AbsensiResponse.class);
    }

    @GetMapping(path = "/{userid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AbsensiResponse> getAbsenByUserid(@PathVariable String userid){
        List<AbsensiDTO> absens = iAbsensiService.getAbsensiByUserid(userid);

        List<AbsensiResponse> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(AbsensiDTO absensiDTO: absens){
            value.add(modelMapper.map(absensiDTO, AbsensiResponse.class));
        }
        return value;
    }


}
