package pl.wojciechkostecki.library.model;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role name;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
