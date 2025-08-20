import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ctof'
})
export class CtofPipe implements PipeTransform {

  transform(value: number | string | null): string {
    const celsius = Number(value);
    if (isNaN(celsius)) return '';
    const fahrenheit = (celsius * 9 / 5) + 32;
    return `${Math.round(fahrenheit)}F`;
  }

}
