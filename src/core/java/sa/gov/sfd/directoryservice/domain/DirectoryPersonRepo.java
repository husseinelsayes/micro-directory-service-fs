package sa.gov.sfd.directoryservice.domain;

import java.io.IOException;
import java.util.List;

import sa.gov.sfd.directoryservice.domain.DirectoryPersonEntity;

public interface DirectoryPersonRepo {
    
	public DirectoryPersonEntity findByUserPrincipalName(String samAccount) throws IOException;
	public List<DirectoryPersonEntity> findByUserDisplayNameEn(String displaynameEn);
	public List<DirectoryPersonEntity> findByUserDisplayNameAr(String displaynameEn);
	public List<DirectoryPersonEntity> findAllUsers();
}