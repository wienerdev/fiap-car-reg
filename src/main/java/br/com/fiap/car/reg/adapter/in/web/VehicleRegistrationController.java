package br.com.fiap.car.reg.adapter.in.web;

import br.com.fiap.car.reg.application.dto.request.CreateVehicleDto;
import br.com.fiap.car.reg.application.dto.request.UpdateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.CreateVehicleResponse;
import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;
import br.com.fiap.car.reg.application.dto.response.UpdateVehicleResponse;
import br.com.fiap.car.reg.application.port.CreateVehicleUseCasePort;
import br.com.fiap.car.reg.application.port.DeleteVehicleUseCasePort;
import br.com.fiap.car.reg.application.port.FindVehicleUseCasePort;
import br.com.fiap.car.reg.application.port.UpdateVehicleUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleRegistrationController {

    private final CreateVehicleUseCasePort createVehicleUseCase;
    private final UpdateVehicleUseCasePort updateVehicleUseCase;
    private final FindVehicleUseCasePort findVehicleUseCase;
    private final DeleteVehicleUseCasePort deleteVehicleUseCase;

    @GetMapping
    public ResponseEntity<List<FindVehicleResponse>> findAllVehicles() throws Exception {
        return new ResponseEntity<>(findVehicleUseCase.findAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindVehicleResponse> findVehicleById(@PathVariable Long id) {
        FindVehicleResponse findVehicleResponseDto = findVehicleUseCase.findVehicleById(id);
        return new ResponseEntity<>(findVehicleResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateVehicleResponse> createVehicle(@RequestBody CreateVehicleDto dto) {
        return new ResponseEntity<>(createVehicleUseCase.createVehicle(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UpdateVehicleResponse> updateVehicle(@RequestBody UpdateVehicleDto dto) throws Exception {
        UpdateVehicleResponse updateVehicleResponseDto = updateVehicleUseCase.updateVehicle(dto);
        return new ResponseEntity<>(updateVehicleResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable Long id) {
        deleteVehicleUseCase.deleteVehicleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}