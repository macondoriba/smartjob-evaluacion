package cl.smartjob.msuser.app.infraestructure.adapters.input.rest;

import cl.smartjob.msuser.app.application.ports.input.RegularExpressionRestServicePort;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.mapper.RegularExpressionRestMapper;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.RegularExpressionCreateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.request.RegularExpressionUpdateRequest;
import cl.smartjob.msuser.app.infraestructure.adapters.input.rest.model.response.RegularExpressionResponse;
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
@RequestMapping("/expressions")
@Tag(name = "Regular Expressions", description = "Regular Expresions management APIs")
public class RegularExpressionRestAdapter {

    private final RegularExpressionRestServicePort port;
    private final RegularExpressionRestMapper mapper;

    @GetMapping()
    public List<RegularExpressionResponse> findAll(){
        return port.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RegularExpressionResponse findById(@PathVariable UUID id){
        return mapper.toResponse(port.findById(id));
    }

    @PostMapping()
    public ResponseEntity<RegularExpressionResponse> save(@Valid @RequestBody RegularExpressionCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toResponse(port.save(mapper.toDomain(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegularExpressionResponse> update(@PathVariable UUID id, @Valid @RequestBody RegularExpressionUpdateRequest request){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(mapper.toResponse(port.update(id, mapper.toDomain(request))));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        port.deleteById(id);
    }
}
