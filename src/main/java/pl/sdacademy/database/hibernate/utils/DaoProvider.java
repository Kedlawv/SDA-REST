package pl.sdacademy.database.hibernate.utils;

import pl.sdacademy.database.hibernate.dao.MemberDao;
import pl.sdacademy.database.hibernate.dao.NfcChipDao;
import pl.sdacademy.database.hibernate.dao.RunDao;
import pl.sdacademy.database.hibernate.daoimpl.MemberDaoImpl;
import pl.sdacademy.database.hibernate.daoimpl.NfcChipDaoImpl;
import pl.sdacademy.database.hibernate.daoimpl.RunDaoImpl;
import pl.sdacademy.database.hibernate.entity.NfcChip;

public class DaoProvider {

    private static DaoProvider instance = new DaoProvider();

    private RunDao runDao;
    private MemberDao memberDao;
    private NfcChipDao nfcChip;

    private DaoProvider() {
        runDao = new RunDaoImpl();
        memberDao = new MemberDaoImpl();
        nfcChip = new NfcChipDaoImpl();
    }

    public static DaoProvider instance() {
        return instance;
    }

    public RunDao getRunDao() {
        return runDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public NfcChipDao getNfcChip() {
        return nfcChip;
    }
}
