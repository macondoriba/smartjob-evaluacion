package cl.smartjob.msuser.app;

import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity.RegularExpressionEntity;
import cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.repository.RegularExpressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class MsUserApplication implements CommandLineRunner {

    private final RegularExpressionRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MsUserApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<RegularExpressionEntity> entities = Arrays.asList(
                new RegularExpressionEntity(null,"000","^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", LocalDateTime.now(),LocalDateTime.now()),
                new RegularExpressionEntity(null,"001","^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$", LocalDateTime.now(),LocalDateTime.now())
        );
        repository.saveAll(entities);
    }
}
