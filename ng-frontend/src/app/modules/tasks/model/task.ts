export class Task {













  id: number;
  taskCode: number;
  projectCode: string;
  description: string;
  priority: string;
  reporter: number;
  assignedUser: number;
  dueDate: number;
  estimation: number;
  updatedDate: number;
  createdDate: number;
  status: String;


  static cloneTask(task: Task): Task {
    const clonedTask: Task = new Task();

    clonedTask.assignedUser = task.assignedUser;
    clonedTask.createdDate = task.createdDate;
    clonedTask.description = task.description;
    clonedTask.dueDate = task.dueDate;
    clonedTask.estimation = task.estimation;
    clonedTask.priority = task.priority;
    clonedTask.reporter = task.reporter;
    clonedTask.taskCode = task.taskCode;
    clonedTask.projectCode = task.projectCode;
    clonedTask.updatedDate  = task.updatedDate;
    clonedTask.id = task.id;
    clonedTask.status = task.status;
    return clonedTask;
  }
}
