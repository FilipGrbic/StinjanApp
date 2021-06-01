import { Deserializable } from "../models/deserializable";

export class Role implements Deserializable{
    roleId: number;
    name: string;
    description: string;

    deserializable(input: any): this {
        Object.assign(this, input);
        return this;
    }
}
