import { Injectable } from '@angular/core';
import { Product } from './product';
import { Products } from './mock-products';

/** Service to collect product data */
@Injectable ()
export class ProductService {

    /** Returns the promise containing the array of products */
    getProducts(): Promise<Product[]> {
        return Promise.resolve(Products);
    }
}
