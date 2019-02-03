package by.subota.max.domain;

import by.subota.max.dao.Identified;
import lombok.Data;

@Data
public class User implements Identified<Integer> {
    private int id;
    private String login;
    private String password;
    private String name;

    // Add your addition fields here...

    @Override
    public Integer getId() {
        return id;
    }

}
