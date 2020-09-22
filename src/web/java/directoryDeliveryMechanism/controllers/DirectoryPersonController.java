package directoryDeliveryMechanism.controllers;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import directoryDeliveryMechanism.view.ApiResponse;
import directoryDeliveryMechanism.view.DirectoryPersonDTO;
import sa.gov.sfd.directoryservice.actions.FindAllPersons;
import sa.gov.sfd.directoryservice.actions.FindDirectoryPersonByAccountName;
import sa.gov.sfd.directoryservice.actions.FindDirectoryPersonByArabicName;
import sa.gov.sfd.directoryservice.actions.FindDirectoryPersonByEnglishName;
import sa.gov.sfd.directoryservice.domain.DirectoryPersonEntity;

@RestController
@RequestMapping("/api/users")
public class DirectoryPersonController {
    @Autowired
    FindDirectoryPersonByAccountName findPersonAccountAction;

    @Autowired
    FindDirectoryPersonByEnglishName findPersonEnglishAction;

    @Autowired
    FindDirectoryPersonByArabicName findPersonArabicAction;

    @Autowired
    FindAllPersons findAllPersonsAction;

    @GetMapping(value = "/acc/{name}")
    public DirectoryPersonEntity getMethodName(@PathVariable String name) throws IOException {
        return findPersonAccountAction.find(name) ;
    }

    @GetMapping(value="/en/{englishName}")
    public List<DirectoryPersonDTO> filterPersonsEn(@PathVariable("englishName") String englishName) {
        return findPersonEnglishAction.find(englishName) ;
    }

    @GetMapping(value="/ar/{arabicName}")
    public List<DirectoryPersonDTO> filterPersonsAr(@PathVariable("arabicName") String arabicName) {
        return findPersonArabicAction.find(arabicName) ;
    }

    @GetMapping(value="/")
    public List<DirectoryPersonDTO> findAllPersons() throws IOException {
        return findAllPersonsAction.findAll() ;
    }

    @GetMapping(value="/generateError")
    public List<DirectoryPersonDTO> generateError() throws UserPrincipalNotFoundException {
        throw new UserPrincipalNotFoundException("name");
    }

    @PostMapping(value="/postTest")
    public ResponseEntity<ApiResponse> postTest() {
        return new ResponseEntity<>(new ApiResponse(true, Arrays.asList("message completed successfully")), HttpStatus.OK);
    }
    
}