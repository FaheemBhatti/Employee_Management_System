import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Employee} from '../employee'
import { EmployeeService } from '../employee.service';
import { UpdateEmployeeComponent } from '../update-employee/update-employee.component';
import { filter} from 'ramda';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  
  public employees:Employee[] = [];

  constructor(
    private employeeService:EmployeeService, 
    private router: Router
    ) {}

  ngOnInit(): void {
     this.getEmployees();
  }
  
  public getEmployees(){
    this.employeeService.getEmployeeList().subscribe(data => {
      this.employees = data;
    });
  }

  public updateEmployee(id:number){
    this.router.navigate([`updateEmployee` , id]);
  }

  public deleteEmployee(employee:Employee){
    this.employeeService.deleteEmployee(employee.id).subscribe({
      next:() => {
        this.employees = filter((e: Employee) => e.id !== employee.id)(this.employees);
      } 
    });
  }
}