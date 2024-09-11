package cl.smartjob.msuser.app.infraestructure.adapters.input.rest;

import cl.smartjob.msuser.app.application.ports.input.UserRestServicePort;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.mapper.UserRestMapper;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.UserCreateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.UserUpdateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "Users", description = "Users management APIs")
public class UserRestAdapter {

    private final UserRestServicePort port;
    private final UserRestMapper mapper;

    @GetMapping()
    public List<UserResponse> findAll(){
        return port.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable UUID id){
        return mapper.toResponse(port.findById(id));
    }

    @PostMapping()
    public ResponseEntity<UserResponse> save(@RequestHeader("Authorization") String authorization,
                                            @Valid @RequestBody UserCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(mapper.toResponse(port.save(authorization,mapper.toDomain(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable UUID id, @Valid @RequestBody UserUpdateRequest request){
         return ResponseEntity.status(HttpStatus.NO_CONTENT)
                 .body(mapper.toResponse(port.update(id, mapper.toDomain(request))));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        port.deleteById(id);
    }
}
