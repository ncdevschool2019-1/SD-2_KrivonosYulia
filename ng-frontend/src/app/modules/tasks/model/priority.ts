export class Priority {

  id: number;
  priorityName: number;



  static clonePriority(status: Priority): Priority {
    const clonedPriority: Priority = new Priority();

    clonedPriority.priorityName = status.priorityName;
    clonedPriority.id = status.id;

    return clonedPriority;
  }
}
