export class Role{
    roleId: number;
    name: string;
    description: string;
    constructor(roleId, name, description){
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }
}
