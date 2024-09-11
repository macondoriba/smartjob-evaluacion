package cl.smartjob.msuser.app.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String name;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Set<PhoneEntity> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;

    @PrePersist
    public void onCreate() {
        this.created = this.lastLogin = this.modified = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.lastLogin = this.modified = LocalDateTime.now();
    }

}