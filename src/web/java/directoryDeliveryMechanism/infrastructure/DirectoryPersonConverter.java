package directoryDeliveryMechanism.infrastructure;

import directoryDeliveryMechanism.view.DirectoryPersonDTO;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonEntity;

public class DirectoryPersonConverter {
    public static DirectoryPersonDTO convertDirectoryPersonDTo(DirectoryPersonEntity person){
        return new DirectoryPersonDTO(
            person.getFullNameAr(),
            person.getFullNameEn(),
            person.getEmail(),
            person.getIpPhone(),
            person.getJobTitle(),
            person.getImage()
        );
    }
}