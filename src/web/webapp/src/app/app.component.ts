import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { OAuthService} from 'angular-oauth2-oidc';
import { authConfig } from './services/sso.config';
import { JwksValidationHandler } from 'angular-oauth2-oidc-jwks';
import { NavigationService } from './services/navigation.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit , OnChanges{
  @Input('state')
  set state(state: string) {
    //console.debug('client received state', state);
  }
  
  constructor(private router: Router,private _oauthService : OAuthService,public navService: NavigationService) {
    //this.configureSSo();
  }


  ngOnChanges(changes: SimpleChanges) {
    //console.log('current state value ',changes.state.currentValue);
    this.navService.sidebarState.sidenavOpen = JSON.parse(changes.state.currentValue).sidenavOpen;
    this.navService.sidebarState.childnavOpen = JSON.parse(changes.state.currentValue).childnavOpen;
  }
  
  ngOnInit() {
    this.router.initialNavigation();
    //this.toggelSidebar();
  }

  configureSSo(){
    this._oauthService.configure(authConfig);
    this._oauthService.tokenValidationHandler = new JwksValidationHandler();
    this._oauthService.tryLogin();
    if(!this._oauthService.hasValidAccessToken()){
      this._oauthService.initImplicitFlow();
    }
  }


  toggelSidebar() {
    const state = this.navService.sidebarState;
    if (state.childnavOpen && state.sidenavOpen) {
      return state.childnavOpen = false;
    }
    if (!state.childnavOpen && state.sidenavOpen) {
      return state.sidenavOpen = false;
    }
    if (!state.sidenavOpen && !state.childnavOpen) {
        state.sidenavOpen = true;
        setTimeout(() => {
            state.childnavOpen = true;
        }, 50);
    }
  }
}
