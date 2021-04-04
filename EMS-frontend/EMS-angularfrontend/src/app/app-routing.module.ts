import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { Employee } from './employee';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {path: `employees` , component:EmployeeListComponent},
  {path: `addEmployees` ,  component:CreateEmployeeComponent},
  {path:`updateEmployee/:id` , component:UpdateEmployeeComponent},
  {path: ``, pathMatch:`full`, redirectTo:`employees`}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
