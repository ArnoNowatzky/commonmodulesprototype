import { Component, OnInit } from '@angular/core';
import { CustomerDTO, CustomerService } from './generated';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'client';

  displayedColumns: string[] = ['id', 'name'];


  dataSource: CustomerDTO[] = [];

  constructor(private softwareService: CustomerService) {
    this.softwareService.getCustomers().subscribe(
      x => this.dataSource = x,
      err => console.error('Observer got an error: ' + err),
      () => console.error('Observer finished'),
    );
  }


}
