import { Component, OnInit } from '@angular/core';
import {MedicationcontainerDTO, MedicationDTO, MedicationsService} from "./generatedCm";
import {PharmacyDTO, PharmacyService} from "./generatedWawi";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'client';

  displayedColumns: string[] = ['id', 'name'];

  medicationContainers: MedicationcontainerDTO[] = [];
  pharmacyInfo: PharmacyDTO = {};

  constructor(private medicationsService: MedicationsService, private pharmacyService: PharmacyService) {
    console.log("Call medicationcontainers")
    this.medicationsService.getMedicationContainers().subscribe(
      x => this.medicationContainers = x,
      err => console.error('Observer got an error: ' + err.message),
      () => console.error('Observer finished'),
    );

    console.log("Call pharmacyinfos")
    this.pharmacyService.getPharmacyInfo().subscribe(
        x => this.pharmacyInfo = x,
        err => console.error('Observer got an error: ' + err.message),
        () => console.error('Observer finished'),
    );
  }


}
