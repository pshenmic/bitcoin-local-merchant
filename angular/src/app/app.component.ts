import {Component, OnInit} from '@angular/core';
import {RestAPIService} from "./services/rest-api/rest-api.service";
import {Product} from "./model/product";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [RestAPIService]
})

export class AppComponent implements OnInit {
  private products: Product[];
  private error;

  constructor(private restAPIService: RestAPIService) {
  }

  ngOnInit() {

  }


}
