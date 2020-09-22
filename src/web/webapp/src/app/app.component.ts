import { Component, OnInit, Input, OnChanges, SimpleChanges, Output, EventEmitter } from '@angular/core';
import { Router, ResolveStart, RouteConfigLoadStart, ResolveEnd, RouteConfigLoadEnd } from '@angular/router';
import { OAuthService} from 'angular-oauth2-oidc';
import { authConfig } from './services/sso.config';
import { JwksValidationHandler } from 'angular-oauth2-oidc-jwks';
import { NavigationService } from './services/navigation.service';
import { NotificationService } from './services/notification.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit , OnChanges{
  @Input('state') state: string;
  @Output() message = new EventEmitter<any>();
  
  constructor(private router: Router,private _oauthService : OAuthService,public navService: NavigationService,private _notificationService : NotificationService) {
    //this.configureSSo();
  }

  ngOnChanges(changes: SimpleChanges) {
    this.navService.sidebarState.sidenavOpen = JSON.parse(changes.state.currentValue).sidenavOpen;
    this.navService.sidebarState.childnavOpen = JSON.parse(changes.state.currentValue).childnavOpen;
  }
  
  ngOnInit() {
    this.router.initialNavigation();
    this._notificationService.appNotification$.subscribe(notification => {
      setTimeout(()=>this.message.emit(notification),0);
    })
    if (event instanceof RouteConfigLoadStart || event instanceof ResolveStart) {
      this._notificationService.loading();
    }
    if (event instanceof RouteConfigLoadEnd || event instanceof ResolveEnd) {
      this._notificationService.ready();
    }
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
