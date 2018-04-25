import {Component, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {RestAPIService} from '../services/rest-api/rest-api.service';
import {OperationPrice} from "../model/operation-price";
import {Order} from "../model/order";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/interval';
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [RestAPIService]
})
export class ProductComponent implements OnInit {

  private error: any;
  private product: Product;
  private operationPrice: OperationPrice;
  private ordered: boolean;
  private order: Order;
  private orderId: number;
  private pathError: boolean;

  constructor(private route: ActivatedRoute,
              private restAPIService: RestAPIService) {
    route.params.subscribe((params => {
      console.log(params.id);
      if(this.isInt(params.id)) {
        this.orderId = params.id;
        console.log(this.orderId);
        this.init();
      } else {
        console.log('Path variable not integer');
        this.pathError = true;
      }
    }));
  }


  ngOnInit() {


  }

  private init() {
    this.restAPIService.getProduct(this.orderId).subscribe(
      product => this.product = product,
      error => this.error = <any> error
    );

    this.restAPIService.getPrice(this.orderId).subscribe(
      operationPrice => this.operationPrice = operationPrice,
      error => this.error = <any> error
    );
  }

  private isInt(n) {
    return n % 1 === 0;
  }

  public errorHandler(error: any) {
    this.error = error;
  }

  public makeOrder(productId: number) {
    if(this.error != null) {
      return;
    }

    this.ordered = true;
    this.restAPIService.makeOrder(productId).subscribe(
      order => {
        this.order = order;
        //Magic line to override first status Unknown
        this.order.status = "PENDING";
        Observable.interval(5000)
          .subscribe(() => {
            this.restAPIService.getOrder(order.id).subscribe(
              order => {
                this.order = order;
              },
              error => this.error = <any> error
            )
          });
      },
      error => this.error = <any> error
    );
  }

  public isPaid(): boolean {
    if (this.order != null && this.order.status != null) {
      return this.order.status === "PAID";
    }
    return false;
  }

  public isExpired(): boolean {
    if (this.order != null && this.order.status != null) {
      return this.order.status === "EXPIRED";
    }
    return false;
  }

  public isPending(): boolean {
    if (this.order != null && this.order.status != null) {
      return this.order.status === "PENDING";
    }
    return false;
  }

  public isUnknown(): boolean {
    if (this.order != null && this.order.status != null) {
      return this.order.status === "UNKNOWN";
    }
    return false;
  }
}
