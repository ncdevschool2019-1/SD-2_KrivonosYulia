export class Project {
  projectCode: string;
  summary: string;
  preparedness : number;


  static cloneProject(project: Project): Project {
    const clonedProject: Project = new Project();
    clonedProject.preparedness = project.preparedness;
    clonedProject.projectCode = project.projectCode;
    clonedProject.summary = project.summary;
    return clonedProject;
  }
}
