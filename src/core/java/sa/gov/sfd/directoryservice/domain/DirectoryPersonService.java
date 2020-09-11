package sa.gov.sfd.directoryservice.domain;

import sa.gov.sfd.directoryservice.domain.DirectoryPersonRepo;

import java.io.IOException;
import java.util.List;

import sa.gov.sfd.directoryservice.domain.DirectoryPersonEntity;

public class DirectoryPersonService {

    private DirectoryPersonRepo personRepo;

    public DirectoryPersonService(DirectoryPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public DirectoryPersonEntity findDirectoryPersonByAccountName(String name) throws IOException {
        return personRepo.findByUserPrincipalName(name);
    }

    public List<DirectoryPersonEntity> findDirectoryPersonsByEnglishName(String name){
        return personRepo.findByUserDisplayNameEn(name);
    }

    public List<DirectoryPersonEntity> findDirectoryPersonsByArabicName(String name){
        return personRepo.findByUserDisplayNameAr(name);
    }

    public List<DirectoryPersonEntity> findAllDirectoryPersons(){
        return personRepo.findAllUsers();
    }
}