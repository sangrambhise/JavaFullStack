import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IVehicle } from './ivehicle';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  // Ex2
    private apiUrl = 'http://localhost:3000/vehicles';

  constructor(private http: HttpClient) { }

  getVehicles(): Observable<IVehicle[]> {
    return this.http.get<IVehicle[]>(this.apiUrl);
  }


  // Ex3
  addVehicle(vehicle: IVehicle): Observable<IVehicle> {
  return this.http.post<IVehicle>(this.apiUrl, vehicle);
}

updateVehicle(id: number, vehicle: IVehicle): Observable<IVehicle> {
  return this.http.put<IVehicle>(`${this.apiUrl}/${id}`, vehicle);
}

deleteVehicle(id: number): Observable<void> {
  return this.http.delete<void>(`${this.apiUrl}/${id}`);
}

}
