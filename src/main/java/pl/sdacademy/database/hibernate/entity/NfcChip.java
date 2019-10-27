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
    private Set<RunMember> runMembers = new HashSet<RunMember>();

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


    public Set<RunMember> getRunMembers() {
        return runMembers;
    }

    public void setRunMembers(Set<RunMember> runMembers) {
        this.runMembers = runMembers;
    }
}
