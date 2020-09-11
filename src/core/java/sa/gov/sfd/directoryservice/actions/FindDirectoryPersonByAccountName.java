package sa.gov.sfd.directoryservice.actions;

import java.io.IOException;

import sa.gov.sfd.directoryservice.domain.DirectoryPersonEntity;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonService;

public class FindDirectoryPersonByAccountName {

    private DirectoryPersonService personService;

    public FindDirectoryPersonByAccountName(DirectoryPersonService personService) {
        this.personService = personService;
    }

    public DirectoryPersonEntity find(String accountName) throws IOException {
        return personService.findDirectoryPersonByAccountName(accountName);
    }

    
}