package pl.sdacademy.database.hibernate.dao;

import pl.sdacademy.database.hibernate.entity.RunMember;

import java.util.List;

public interface MemberDao {
    void save(RunMember runMember);
    void delete(Long id);
    RunMember getById(Long id);
    List<RunMember> getAll();
}
