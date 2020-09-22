import { Injectable, Output, EventEmitter } from '@angular/core';
import { Subject, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private _appNotificationSubject : Subject<AppNotification>;
  appNotification$ : Observable<AppNotification>;
  private _notification : AppNotification;

  constructor() {
    this._appNotificationSubject = new Subject<AppNotification>();
    this.appNotification$ = this._appNotificationSubject.asObservable();
  }

  loading(){
    console.log('from notification service ==> on loading');
    let notification = new AppNotification('state','initializing'); 
    this._notification = notification;
    this._appNotificationSubject.next(notification);
  }

  ready(){
    console.log('from notification service ==> on ready');
    let notification = new AppNotification('state','ready'); 
    this._notification = notification;
    this._appNotificationSubject.next(notification);
  }

  success(msg : string[]){
    console.log('from notification service ==> on success');
    let notification = new AppNotification('success',msg); 
    this._notification = notification;
    this._appNotificationSubject.next(notification);
  }

  error(msg : string[]){
    console.log('from notification service ==> on error');
    let notification = new AppNotification('error',msg); 
    this._notification = notification;
    this._appNotificationSubject.next(notification);
  }
}


class AppNotification{
  constructor(public type,public payload){}
}
