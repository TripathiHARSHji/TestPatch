import { Component } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  id: number=0;
  username: string='';
  email: string='';

  constructor(private userService: UserService) { }

  updateUserDetails(): void {
    this.userService.updateUserDetails(this.id, this.username, this.email)
      .subscribe(
        () => {
          // Success handling (e.g., display a success message)
        },
        (error) => {
          // Error handling (e.g., display an error message)
        }
      );
  }
}
