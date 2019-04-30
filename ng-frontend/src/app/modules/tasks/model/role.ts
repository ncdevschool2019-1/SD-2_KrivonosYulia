export class Role {

  id: number;
  roleName: number;



  static cloneRole(role: Role): Role {
    const clonedRole: Role = new Role();

    clonedRole.roleName = role.roleName;
    clonedRole.id = role.id;

    return clonedRole;
  }
}
