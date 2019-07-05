package pl.sdacademy.database.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class NfcChip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serial;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "chips")
    @JsonIgnore
    private Set<Member> members = new HashSet<Member>();

    public NfcChip(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }


    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
