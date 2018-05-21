package az.itstep.azjava.testapp.model.dto;

import az.itstep.azjava.testapp.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO {
    private Integer id;
    private String text;
    private Data sendTime;
    private Integer senderId;
    private  Integer receiverId;

}
