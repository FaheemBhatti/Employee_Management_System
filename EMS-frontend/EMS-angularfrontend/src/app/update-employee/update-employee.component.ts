import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  id:number = 0;
  employee: Employee = new Employee();
  constructor(
    private employeeService:EmployeeService,
    private router:ActivatedRoute, 
    private router1:Router) {}

  ngOnInit(): void {
    this.id = this.router.snapshot.params['id'];
    
    this.employeeService.getEmployeeById(this.id).subscribe(data =>{
      this.employee = data;
    })
  }
  
  updateEmployee(){
    
    this.employeeService.updateEmployee(this.id , this.employee).subscribe(data =>{
      console.log(data);
    })
    this.gotoEmployeeList();
  } 

  gotoEmployeeList(){
    this.router1.navigate(['/employees']);
  }

  onSubmit(){
    this.updateEmployee();
  }

}
