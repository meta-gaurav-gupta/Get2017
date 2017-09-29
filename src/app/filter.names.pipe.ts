import { Pipe, PipeTransform } from '@angular/core';
import { User } from './pages/home/user';
/*
 * Raise the value exponentially
 * Takes an exponent argument that defaults to 1.
 * Usage:
 *   value | exponentialStrength:exponent
 * Example:
 *   {{ 2 | exponentialStrength:10 }}
 *   formats to: 1024
*/
@Pipe({name: 'fitlerName'})
export class FilterNamePipe implements PipeTransform {
  transform(users: User[], id: number): string {
    console.log(id);
    const name = users.find(user => user.id === id).name;
    console.log(name);
    return name;
  }
}
