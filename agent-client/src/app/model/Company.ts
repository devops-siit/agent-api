import { Account } from "./Account";

export class Company{
    uuid?: string;
    name?: string;
    phone?: string;
    address?: string;
    description?: string;
    owner?: Account;
}