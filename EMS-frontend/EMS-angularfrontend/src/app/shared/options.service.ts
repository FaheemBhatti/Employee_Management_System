import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OptionsService {
    public isProduction = environment.production;
    public baseUrl = environment.baseUrl;
    public baseUrlApi = environment.apiUrl;
}
