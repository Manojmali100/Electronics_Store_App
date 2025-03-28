package electronics_store.Dto;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseMessage {

    private String message;

    private boolean Success;

    private HttpStatus status;
}
