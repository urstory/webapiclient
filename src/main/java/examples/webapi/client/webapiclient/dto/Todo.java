package examples.webapi.client.webapiclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Todo {
    private Long id;
    private String todo;
    private boolean done;
    private LocalDateTime regdate;

    public Todo(){
        regdate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", todo='" + todo + '\'' +
                ", done=" + done +
                ", regdate=" + regdate +
                '}';
    }
}
