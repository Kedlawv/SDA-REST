package pl.sdacademy.database.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RunMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer startNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_run")
    @JsonIgnore
    private Run run;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "chip_member",
               joinColumns = {@JoinColumn(name = "member_id")},
               inverseJoinColumns = {@JoinColumn(name = "chip_id")})
    private Set<NfcChip> chips = new HashSet<NfcChip>();

    public RunMember() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Integer startNumber) {
        this.startNumber = startNumber;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public Set<NfcChip> getChips() {
        return chips;
    }

    public void setChips(Set<NfcChip> chips) {
        this.chips = chips;
    }
}
