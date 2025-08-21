import { Component } from '@angular/core';
import { IVehicle } from '../ivehicle';
import { VehicleService } from '../vehicle.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vehicle-comp',
  imports: [CommonModule,FormsModule],
  templateUrl: './vehicle-comp.component.html',
  styleUrl: './vehicle-comp.component.css'
})
export class VehicleCompComponent {
  // Ex2
  vehicles: IVehicle[] = [];

  // Ex3
  vehicleForm: IVehicle = this.getEmptyVehicle();
  isEditMode = false;
  constructor(private vehicleService: VehicleService) {}
  // Ex2
  // ngOnInit(): void {
  //   this.vehicleService.getVehicles().subscribe(data => {
  //     this.vehicles = data;
  //   });
  // }

  // Ex3
  ngOnInit(): void {
    this.getAllVehicles();
  }

  getAllVehicles() {
    this.vehicleService.getVehicles().subscribe((data) => {
      this.vehicles = data;
    });
  }

  onSubmit() {
    if (this.isEditMode && this.vehicleForm.id != null) {
     console.log('Updating vehicle ID:', this.vehicleForm.id);
      this.vehicleService.updateVehicle(this.vehicleForm.id, this.vehicleForm).subscribe(() => {
        this.getAllVehicles();
        this.resetForm();
      });
    } else {
      this.vehicleService.addVehicle(this.vehicleForm).subscribe(() => {
        this.getAllVehicles();
        this.resetForm();
      });
    }
  }

  onEdit(vehicle: IVehicle) {
    console.log('Editing vehicle:', vehicle);
    this.vehicleForm = { ...vehicle }; 
    this.isEditMode = true;
  }

  onDelete(id: number | undefined) {
    if (!id) return;
    this.vehicleService.deleteVehicle(id).subscribe(() => {
      this.getAllVehicles();
    });
  }

  resetForm() {
    this.vehicleForm = this.getEmptyVehicle();
    this.isEditMode = false;
  }

  getEmptyVehicle(): IVehicle {
    return {
      make: '',
      model: '',
      fuelType: '',
      price: 0
    };
  }

}
