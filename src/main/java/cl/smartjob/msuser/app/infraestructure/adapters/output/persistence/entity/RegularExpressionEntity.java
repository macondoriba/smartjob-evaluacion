package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "regular_expresions")
public class RegularExpressionEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String code;
    private String expression;
    private LocalDateTime created;
    private LocalDateTime modified;

    @PrePersist
    public void onCreate() {
        this.created = this.modified = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.modified = LocalDateTime.now();
    }

}