import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person';
import { FormControl } from '@angular/forms';
import { debounceTime } from 'rxjs/operators';
import { ContatcsService } from 'src/app/services/contatcs.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-find-contact',
  templateUrl: './find-contact.component.html',
  styleUrls: ['./find-contact.component.scss']
})
export class FindContactComponent implements OnInit {
  searchControl: FormControl = new FormControl();
  persons : Person[];
  filteredPersons : Person[];

  constructor(private _contactsService : ContatcsService,private _http: HttpClient) { }

  ngOnInit() {
    this.getAllContacts();
    this.searchControl.valueChanges
    .pipe(debounceTime(200))
    .subscribe(value => {
      if(value != ''){
        console.log(value);
        this.getContactsByArabicName(value);
      }else{
        this.filteredPersons = this.persons;
      }
    });
  }


  getContactsByArabicName(val) {
    this.filteredPersons = this.filteredPersons.filter(x => {
      if(x.name_ar){
        return x.name_ar.includes(val);
      }else
      {
        return false;
      }
  });
  }

  
  getAllContacts(){
    this._contactsService.getAllContacts().subscribe((personList : Person[])=>{
      this.persons = personList.filter(x => x.jobTitle);
      //this.persons = personList;
      this.filteredPersons = this.persons;
    },error => {
      console.log(error);
    })
  }
    
}
