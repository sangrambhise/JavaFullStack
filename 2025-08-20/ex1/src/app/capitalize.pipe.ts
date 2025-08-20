import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'capitalize'
})
export class CapitalizePipe implements PipeTransform {
  // Ex1
  transform(value: string): string {
    return value?.toUpperCase() || '';
  }
}
