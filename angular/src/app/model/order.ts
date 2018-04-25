import {Product} from './product';
import {OperationPrice} from './operation-price';

export class Order {

  public id: number;
  public product: Product;
  public address: string;
  public time: number;
  public operationPrice: OperationPrice;
  public status: string;

}
