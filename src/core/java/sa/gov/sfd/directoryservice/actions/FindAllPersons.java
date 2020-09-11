package sa.gov.sfd.directoryservice.actions;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import directoryDeliveryMechanism.infrastructure.DirectoryPersonConverter;
import directoryDeliveryMechanism.view.DirectoryPersonDTO;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonService;

public class FindAllPersons {
    private DirectoryPersonService personService;

    public FindAllPersons(DirectoryPersonService personService) {
        this.personService = personService;
    }

    public List<DirectoryPersonDTO> findAll() throws IOException {
        return personService.findAllDirectoryPersons().stream().map(DirectoryPersonConverter::convertDirectoryPersonDTo).collect(Collectors.toList());
    }
}