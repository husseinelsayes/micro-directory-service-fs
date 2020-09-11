package sa.gov.sfd.directoryservice.actions;

import java.util.List;
import java.util.stream.Collectors;

import directoryDeliveryMechanism.infrastructure.DirectoryPersonConverter;
import directoryDeliveryMechanism.view.DirectoryPersonDTO;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonService;

public class FindDirectoryPersonByEnglishName {
    private DirectoryPersonService personService;

    public FindDirectoryPersonByEnglishName(DirectoryPersonService personService) {
        this.personService = personService;
    }

    public List<DirectoryPersonDTO> find(String englishName){
        return personService.findDirectoryPersonsByEnglishName(englishName).stream().map(DirectoryPersonConverter::convertDirectoryPersonDTo).collect(Collectors.toList());
    }
}