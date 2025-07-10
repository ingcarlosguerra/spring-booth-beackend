package pruebatecnica.server.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequest {

    @NotBlank(message = "typeId es obligatorio")
    private String typeId;

    @NotBlank(message = "id es obligatorio")
    @Pattern(regexp = "\\d+", message = "id debe ser un número")
    private String id;

    public UserRequest() {
    }

    public UserRequest(String typeId, String id) {
        this.typeId = typeId;
        this.id     = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
