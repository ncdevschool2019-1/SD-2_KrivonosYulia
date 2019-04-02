export class User {
  id: number;
  password: string;
  email: string;
  role: string;
  name: string;
  surname: string;

  static cloneUser(user: User): User {
    const clonedUser: User = new User();
    clonedUser.id = user.id;

    clonedUser.password = user.password;
    clonedUser.email = user.email;
    clonedUser.role = user.role;
    clonedUser.name = user.name;
    clonedUser.surname = user.surname;
    return clonedUser;
  }
}
