package pruebatecnica.server.service;

import org.springframework.stereotype.Service;
import pruebatecnica.server.api.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        userList.addAll(Arrays.asList(
                new User("cedula",     "1049642715",  "Carlos",   "Andrés",    "Pérez",     "Gómez",
                        "+57 300-123-0001", "Calle 1 #1-01",        "Bogotá D.C."),
                new User("cedula",     "2536598741",  "María",    "Alejandra","Rodríguez", "López",
                        "+57 300-123-0002", "Cra 2 #2-02",          "Medellín"),
                new User("cedula",     "73920184652", "Juan",     "Esteban",  "García",    "Restrepo",
                        "+57 300-123-0003", "Av. 3 #3-03",          "Cali"),
                new User("cedula",     "18472639",    "Laura",    "Isabel",   "Martínez",  "Jiménez",
                        "+57 300-123-0004", "Cl. 4 #4-04",          "Barranquilla"),
                new User("cedula",     "908172635419","Andrés",   "Felipe",   "Suárez",    "Castro",
                        "+57 300-123-0005", "Cl. 5 #5-05",          "Bucaramanga"),
                new User("cedula",     "5019273648",  "Diana",    "Carolina", "Torres",    "Mejía",
                        "+57 300-123-0006", "Cl. 6 #6-06",          "Cartagena"),
                new User("cedula",     "376590182",   "Santiago", "David",    "Ramírez",   "Hernández",
                        "+57 300-123-0007", "Cl. 7 #7-07",          "Pereira"),
                new User("cedula",     "918273645",   "Paula",    "Andrea",   "Fernández", "Arias",
                        "+57 300-123-0008", "Cl. 8 #8-08",          "Manizales"),
                new User("pasaporte",  "564738291056","Michael",  "James",    "Smith",     "Johnson",
                        "+1 555-010-1001",  "742 Evergreen Terrace","Springfield, IL"),
                new User("pasaporte",  "4039182756",  "Emily",    "Grace",    "Brown",     "Davis",
                        "+44 20-1234-5678", "221B Baker St",         "London"),
                new User("pasaporte",  "82736495012", "Lucas",    "Gabriel",  "Silva",     "Costa",
                        "+55 11-4004-1616", "Rua Augusta 1234",      "São Paulo"),
                new User("cedula",     "10293847",    "Camila",   "Sofía",    "Moreno",    "Salazar",
                        "+57 300-123-0009", "Cl. 9 #9-09",           "Cúcuta"),
                new User("cedula",     "564738291",   "Felipe",   "Julián",   "Ortiz",     "Villegas",
                        "+57 300-123-0010", "Cl. 10 #10-10",         "Ibagué"),
                new User("pasaporte",  "192837465091","Anna",     "Marie",    "Müller",    "Schmidt",
                        "+49 89-123-4560",  "Marienplatz 1",         "Múnich"),
                new User("pasaporte",  "9081726354",  "Yuki",     "Haruto",   "Tanaka",    "Sato",
                        "+81 3-1234-5678",  "1-1 Chiyoda",           "Tokio")
        ));
    }


    public Optional<User> findByTypeAndId(String typeId, String id) {
        return userList.stream()
                .filter(u -> u.getTypeId().equalsIgnoreCase(typeId)
                        && u.getId().equals(id))
                .findFirst();
    }


    public List<User> findAll() {
        return List.copyOf(userList);
    }

}
