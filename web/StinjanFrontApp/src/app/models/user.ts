import { Role } from "../models/role";

export class User{
    userId: number;
    role: Role;
    name: string;
    surname: string;
    country: string;
    city: string;
    address: string;
    email: string;
    phone: string;
    username: string;
    password: string;
    description: string;
}
