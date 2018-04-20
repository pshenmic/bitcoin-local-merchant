import {Component, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {RestAPIService} from '../services/rest-api/rest-api.service';
import {OperationPrice} from "../model/operation-price";
import {Order} from "../model/order";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/interval';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
  providers: [RestAPIService]
})
export class ProductsComponent implements OnInit {

  private error: any;
  private products: Product[];
  private operationPrice: OperationPrice;
  private ordered: boolean;
  private order: Order;

  constructor(private restAPIService: RestAPIService) {
  }

  ngOnInit() {
    this.restAPIService.getProducts().subscribe(
      products => this.products = products,
      error => this.error = <any> error
    );
  }

}
