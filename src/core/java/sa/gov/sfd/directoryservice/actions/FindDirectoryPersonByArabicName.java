package sa.gov.sfd.directoryservice.actions;

import java.util.List;
import java.util.stream.Collectors;

import directoryDeliveryMechanism.infrastructure.DirectoryPersonConverter;
import directoryDeliveryMechanism.view.DirectoryPersonDTO;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonService;

public class FindDirectoryPersonByArabicName {
    private DirectoryPersonService personService;

    public FindDirectoryPersonByArabicName(DirectoryPersonService personService) {
        this.personService = personService;
    }

    public List<DirectoryPersonDTO> find(String arabicName){
        return personService.findDirectoryPersonsByArabicName(arabicName).stream().map(DirectoryPersonConverter::convertDirectoryPersonDTo).collect(Collectors.toList());
    }
}