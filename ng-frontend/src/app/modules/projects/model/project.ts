export class Project {
  id: number;
  projectCode: string;
  summary: string;



  static cloneProject(project: Project): Project {
    const clonedProject: Project = new Project();
    clonedProject.projectCode = project.projectCode;
    clonedProject.summary = project.summary;
    return clonedProject;
  }
}
