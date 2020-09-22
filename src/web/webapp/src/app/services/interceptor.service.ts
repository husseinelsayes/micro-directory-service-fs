import { Injectable } from '@angular/core';
import {HttpResponse,HttpRequest,HttpHandler,HttpEvent,HttpInterceptor,HttpErrorResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { LoaderService } from '../services/loader.service';
import { NotificationService } from './notification.service';

@Injectable({
  providedIn: 'root'
})

export class InterceptorService implements HttpInterceptor{

  constructor(private _notificationService : NotificationService) { }
  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this._notificationService.loading();
    return next.handle(req).pipe(tap((httpResponse: HttpEvent<any>) => { 
      if (httpResponse instanceof HttpResponse) {
        if(req.method == 'POST' || req.method == 'PUT' || req.method == 'DELETE'){
          this._notificationService.success(httpResponse.body.payload);
        }else{
          this._notificationService.ready();
        }
      }
    },
      (err: any) => {
        if (err instanceof HttpErrorResponse) {
          if(err.error.payload){
            this._notificationService.error(err.error.payload);
          }else{
            this._notificationService.error(['خطأ في تنفيذ الطلب .. يرجى المحاولة لاحقاً']);
          }
          
        }
    }));
  }  
}
