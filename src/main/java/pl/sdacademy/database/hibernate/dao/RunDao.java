package pl.sdacademy.database.hibernate.dao;

import pl.sdacademy.database.hibernate.entity.Run;

import java.util.Date;
import java.util.List;

public interface RunDao {
    void save(Run run);
    void delete(Long id);
    Run getById(Long id);
    List<Run> getAll();
    List<Run> getAll(int seek, int count);
    List<Run> findByDate(Date dateFrom, Date dateTo, int seek, int count);
}
