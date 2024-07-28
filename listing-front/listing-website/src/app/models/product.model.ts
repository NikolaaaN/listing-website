import { User } from './user.model';

export interface Product {
  id?: number;
  price: number;
  description: String;
  name: String;
  image: String;
  email?: String;
}
