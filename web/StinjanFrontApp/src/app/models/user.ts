import { Role } from "../models/role";
import { Deserializable } from "../models/deserializable";

export class User implements Deserializable{
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

    constructor(){}
    deserializable(input: any): this {
        Object.assign(this, input);
        return this;
    }
}
