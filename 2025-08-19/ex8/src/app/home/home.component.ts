import { Component } from '@angular/core';
import { TasklistComponent } from '../tasklist/tasklist.component';
import { TaskComponent } from '../task/task.component';
import { Task } from '../task';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-home',
  imports: [CommonModule,TasklistComponent,TaskComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  // Ex8
tasks: Task[] = [];
  nextId = 1;

addTask(task: Task) {
  const newTask: Task = {
    id: this.nextId++,
    ...task
  };
  this.tasks.push(newTask);
}

  deleteTask(id: number) {
    this.tasks = this.tasks.filter(task => task.id !== id);
  }
}
