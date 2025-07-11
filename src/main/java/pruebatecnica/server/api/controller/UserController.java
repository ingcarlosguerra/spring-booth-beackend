package pruebatecnica.server.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import pruebatecnica.server.api.dto.ApiResponse;
import pruebatecnica.server.api.dto.UserRequest;
import pruebatecnica.server.api.model.User;
import pruebatecnica.server.service.UserService;

import java.util.List;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @CrossOrigin(origins = "https://prueba-tecnica-front-nu.vercel.app/")
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<User>> findByTypeAndId(
            @RequestBody @Valid UserRequest request) {

        String typeId = request.getTypeId().toLowerCase().trim();
        String id     = request.getId().trim();

        if (!typeId.matches("^(?i)(cedula|pasaporte)$")) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "tipo de documento solo puede ser: cedula, pasaporte"
            );
        }
        if (!id.matches("\\d+")) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "id debe contener sólo dígitos"
            );
        }

        User user = userService
                .findByTypeAndId(typeId, id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("El usuario no se encontró; revise typeId=%s o id=%s", typeId, id)
                ));

        ApiResponse<User> resp = new ApiResponse<>("exitoso", user);
        return ResponseEntity.ok(resp);
    }
}
