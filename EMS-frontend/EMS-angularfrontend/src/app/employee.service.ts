import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { OptionsService } from './shared/options.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(
    private readonly httpClient:HttpClient , 
    private readonly _optionService: OptionsService
    ) {}

  public getEmployeeList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(`${this._optionService.baseUrl}/api/v1/allEmployee`); 
  }

  public createEmployee(employees:Employee): Observable<Object> {
    return this.httpClient.post(`${this._optionService.baseUrl}/api/v1/addEmployee`, employees);
  }

  public getEmployeeById(id:number) : Observable<Employee>{
    return this.httpClient.get<Employee>(`${this._optionService.baseUrl}/api/v1/allEmployee/${id}`);
  }

  public updateEmployee(id:number , employee:Employee){
    return this.httpClient.put(`${this._optionService.baseUrl}/api/v1/updateEmployee/${id}` , employee);
  }

  public deleteEmployee(id:number){
    return this.httpClient.delete(`${this._optionService.baseUrl}/api/v1/deleteEmployee/${id}`);
  }
}