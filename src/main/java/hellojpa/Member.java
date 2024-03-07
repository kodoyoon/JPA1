package hellojpa;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    //기간 Period
    @Embedded
    private Period workperiod;

    //주소
    @Embedded
    private Address homeaddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getWorkperiod() {
        return workperiod;
    }

    public void setWorkperiod(Period workperiod) {
        this.workperiod = workperiod;
    }

    public Address getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(Address homeaddress) {
        this.homeaddress = homeaddress;
    }
}
