export class Status {

  id: number;
  status: number;



  static cloneStatus(status: Status): Status {
    const clonedStatus: Status = new Status();

    clonedStatus.status = status.status;
    clonedStatus.id = status.id;

    return clonedStatus;
  }
}
