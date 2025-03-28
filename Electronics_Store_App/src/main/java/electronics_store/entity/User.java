package electronics_store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Column(name = "User_name")
    private String name;
    @Column(name = "user_email", unique = true)
    private String email;
    @Column(name = "user_Password", length = 10)
    private String password;
    private String gender;
    @Column(length = 1000)
    private String about;
    
    private String imageName;
}
