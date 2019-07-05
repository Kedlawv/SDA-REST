package pl.sdacademy.database.hibernate.dao;

import pl.sdacademy.database.hibernate.entity.Member;

import java.util.List;

public interface MemberDao {
    void save(Member member);
    void delete(Long id);
    Member getById(Long id);
    List<Member> getAll();
}
