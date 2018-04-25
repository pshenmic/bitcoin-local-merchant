import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Product} from '../../model/product';
import {OperationPrice} from "../../model/operation-price";
import {Order} from "../../model/order";

import 'rxjs/add/observable/throw';
import {Observable} from "rxjs";

@Injectable()
export class RestAPIService {


  constructor(private http: Http) {
    console.log('Service')
  }


  public logError(err) {
    console.log(err);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body;
  }


  private handleError(error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    /*let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }*/
    let model = {test: true};
    return Observable.throw(error);

  }

  getProducts(): Observable<Product[]> {
    return this.http.get('/api/product/getAll')
      .map(this.extractData)
      .catch(this.handleError);
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get('/api/product/' + id)
      .map(this.extractData)
      .catch(this.handleError);
  }

  getPrice(id: number): Observable<OperationPrice> {
    return this.http.get('/api/product/' + id + '/price')
      .map(this.extractData)
      .catch(this.handleError);
  }

  makeOrder(id: number): Observable<Order> {
    return this.http.get('/api/product/' + id + '/order')
      .map(this.extractData)
      .catch(this.handleError);
  }

  getOrder(id: number): Observable<Order> {
    return this.http.get('/api/order/' + id)
      .map(this.extractData)
      .catch(this.handleError);
  }

}
