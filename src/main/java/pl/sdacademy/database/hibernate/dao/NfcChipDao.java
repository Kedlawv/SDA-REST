package pl.sdacademy.database.hibernate.dao;

import pl.sdacademy.database.hibernate.entity.NfcChip;

import java.util.List;

public interface NfcChipDao {
    void save(NfcChip chip);
    void delete(Long id);
    NfcChip getById(Long id);
    List<NfcChip> getAll();
}
