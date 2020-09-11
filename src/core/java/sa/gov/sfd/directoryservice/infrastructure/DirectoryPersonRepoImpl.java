package sa.gov.sfd.directoryservice.infrastructure;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;

import sa.gov.sfd.directoryservice.domain.DirectoryPersonEntity;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonRepo;

public class DirectoryPersonRepoImpl implements DirectoryPersonRepo {

	@Autowired
	LdapTemplate ldapTemplate;

	@Override
	public DirectoryPersonEntity findByUserPrincipalName(String samAccount) throws IOException {
		DirectoryPersonEntity person = ldapTemplate.findOne(query().where("samAccountName").is(samAccount), DirectoryPersonEntity.class);
		// ByteArrayInputStream bis = new ByteArrayInputStream(person.getImage());
		// BufferedImage  bufImg = ImageIO.read(bis);
		// ImageIO.write(bufImg,"jpeg",new File("person.jpeg"));
		return person;
	}

	@Override
	public List<DirectoryPersonEntity> findByUserDisplayNameEn(String displaynameEn) {
		LdapQuery query = query().where("displayName").like(displaynameEn + "*");
		List<DirectoryPersonEntity> persons = ldapTemplate.find(query, DirectoryPersonEntity.class);
		return persons;
	}

	@Override
	public List<DirectoryPersonEntity> findByUserDisplayNameAr(String displaynameAr) {
		LdapQuery query = query().where("description").like("*" + displaynameAr + "*");
		List<DirectoryPersonEntity> persons = ldapTemplate.find(query, DirectoryPersonEntity.class);
		return persons;
	}

	@Override
	public List<DirectoryPersonEntity> findAllUsers() {
		List<DirectoryPersonEntity> persons = ldapTemplate.findAll(DirectoryPersonEntity.class);
		return persons;
	}
    
}