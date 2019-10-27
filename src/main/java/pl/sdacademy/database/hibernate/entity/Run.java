package pl.sdacademy.database.hibernate.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 300)
    private String name;
    private String place;
    private Date startDate;
    private Integer membersLimit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "run")
    private Set<RunMember> runMembers = new HashSet<RunMember>();

    public Run() {

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getMembersLimit() {
        return membersLimit;
    }

    public void setMembersLimit(Integer membersLimit) {
        this.membersLimit = membersLimit;
    }

    public Set<RunMember> getRunMembers() {
        return runMembers;
    }

    public void setRunMembers(Set<RunMember> runMembers) {
        this.runMembers = runMembers;
    }
}
