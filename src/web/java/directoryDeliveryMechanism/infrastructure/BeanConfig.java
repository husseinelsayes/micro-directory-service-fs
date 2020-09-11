package directoryDeliveryMechanism.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sa.gov.sfd.directoryservice.actions.FindAllPersons;
import sa.gov.sfd.directoryservice.actions.FindDirectoryPersonByAccountName;
import sa.gov.sfd.directoryservice.actions.FindDirectoryPersonByArabicName;
import sa.gov.sfd.directoryservice.actions.FindDirectoryPersonByEnglishName;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonRepo;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonService;
import sa.gov.sfd.directoryservice.infrastructure.DirectoryPersonRepoImpl;

@Configuration
public class BeanConfig {
    
    //REPOSITORIES
    @Bean
    DirectoryPersonRepo directoryPersonRepo(){
        return new DirectoryPersonRepoImpl();
    }
    //SERVICES
    @Bean
    DirectoryPersonService directoryPersonService(){
        return new DirectoryPersonService(directoryPersonRepo());
    }
    //ACTIONS
    @Bean
    FindDirectoryPersonByAccountName findDirectoryPersonByAccountNameAction(){
        return new FindDirectoryPersonByAccountName(directoryPersonService());
    }

    @Bean
    FindDirectoryPersonByEnglishName findDirectoryPersonByEnglishNameAction(){
        return new FindDirectoryPersonByEnglishName(directoryPersonService());
    }

    @Bean
    FindDirectoryPersonByArabicName findDirectoryPersonByArabicNameAction(){
        return new FindDirectoryPersonByArabicName(directoryPersonService());
    }

    @Bean
    FindAllPersons findAllPersonsAction(){
        return new FindAllPersons(directoryPersonService());
    }

}