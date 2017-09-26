import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { Products } from './mock-products';
import { ProductService } from './product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  title = 'Products';
  products = Products;
  constructor(private productService: ProductService) {}

  /** Override */
  ngOnInit() {
    this.getProducts();
  }

  /** Get products from service */
  getProducts(): void {
    this.productService.getProducts().then(products => this.products = products);
  }

}
