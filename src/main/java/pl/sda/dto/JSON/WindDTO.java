package pl.sda.dto.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindDTO {
    private float speed;
    private int deg; //degree
}
