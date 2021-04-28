package org.bsim.intern.ui.controller;

import org.bsim.intern.service.iservice.IPengajuanIzinService;
import org.bsim.intern.shared.dto.PengajuanIzinDTO;
import org.bsim.intern.ui.model.request.PengajuanIzinRequest;
import org.bsim.intern.ui.model.response.PengajuanIzinResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/izin")
public class PengajuanIzinController {
    private final IPengajuanIzinService iPengajuanIzinService;

    public PengajuanIzinController(IPengajuanIzinService iPengajuanIzinService) {
        this.iPengajuanIzinService = iPengajuanIzinService;
    }

    @PostMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public PengajuanIzinResponse addNewPengajuanIzin(@PathVariable String userId, @RequestBody PengajuanIzinRequest izin){
        ModelMapper modelMapper = new ModelMapper();

        PengajuanIzinDTO pengajuanIzinDTO = modelMapper.map(izin, PengajuanIzinDTO.class);
        PengajuanIzinDTO createdPengajuanIzin = iPengajuanIzinService.addNewPengajuanIzin(userId, pengajuanIzinDTO);

        PengajuanIzinResponse returnResponse = modelMapper.map(createdPengajuanIzin, PengajuanIzinResponse.class);
        return returnResponse;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PengajuanIzinResponse> getAllIzins(){
        List<PengajuanIzinDTO> izins = iPengajuanIzinService.getListIzin();

        List<PengajuanIzinResponse> value = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(PengajuanIzinDTO pengajuanIzinDTO: izins){
            value.add(modelMapper.map(pengajuanIzinDTO, PengajuanIzinResponse.class));
        }
        return value;
    }

    @PutMapping(path = "/{userId}/{izinId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PengajuanIzinResponse updateStatusIzin(@PathVariable String userId,
                                                  @PathVariable String izinId,
                                                  @RequestBody PengajuanIzinRequest pengajuanIzinRequest){
        ModelMapper mapper = new ModelMapper();

        PengajuanIzinDTO pengajuanIzinDTO = mapper.map(pengajuanIzinRequest, PengajuanIzinDTO.class);
        PengajuanIzinDTO updateStatus = iPengajuanIzinService.updateStatusIzin(userId, izinId, pengajuanIzinDTO);
        return mapper.map(updateStatus, PengajuanIzinResponse.class);
    }

}
