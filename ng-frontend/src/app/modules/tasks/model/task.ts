import {UserService} from "../../../services/user.service";
import {User} from "../../user-account/model/user";
import {Priority} from "./priority";
import {Project} from "../../projects/model/project";
import {Status} from "./status";

export class Task {

  id: number;
  taskCode: number;
  projectCode: Project;
  description: string;
  priority: Priority;
  reporter: User;
  assignedUser: User;
  dueDate: number;
  estimation: number;
  updatedDate: number;
  createdDate: number;
  status: Status;


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
