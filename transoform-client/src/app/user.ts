export class User {
  id!: number;
  username!: string;
  password!: string;
  email!: string;
  roles: String[] = [];
  active!: boolean;
  activationCode!: string;
}
