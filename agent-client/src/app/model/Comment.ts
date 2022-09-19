import { Account } from 'src/app/model/Account';
export interface Comment{

    uuid?: string;
    text?: string;
    author?: Account;
  }