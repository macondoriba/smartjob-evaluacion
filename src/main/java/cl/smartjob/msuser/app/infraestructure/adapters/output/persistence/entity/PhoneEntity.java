package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="phones")
public class PhoneEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,referencedColumnName = "id")
    private UserEntity user;
    private String  number;
    private String cityCode;
    private String countryCode;
}