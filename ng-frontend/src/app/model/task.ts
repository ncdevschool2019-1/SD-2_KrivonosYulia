
export class Task {

  ticketCode: number;
  projectCode: string;
  description: string;
  priority: string;
  reporterEmail: string;
  assigneeEmail: string;
  dueDate: string;
  estimation: string;
  updateDate: string;
  createDate: string;



  static cloneTask(task: Task): Task {
    const clonedTask: Task = new Task();

    clonedTask.assigneeEmail = task.assigneeEmail;
    clonedTask.createDate = task.createDate;
    clonedTask.description = task.description;
    clonedTask.dueDate = task.dueDate;
    clonedTask.estimation = task.estimation;
    clonedTask.priority = task.priority;
    clonedTask.reporterEmail = task.reporterEmail;
    clonedTask.ticketCode = task.ticketCode;
    clonedTask.projectCode = task.projectCode;
    clonedTask.updateDate  = task.updateDate;

    return clonedTask;
  }
}
