import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit{
  customers!:any
  constructor(private http:HttpClient,private router:Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/customer-service/customers?projection=fullCustomer").subscribe({
      next:value => {
        this.customers=value;
      },error:err => {
        err.message;
      }
    })

  }


  getYourOrders(customer: any) {
    this.router.navigateByUrl("/orders/"+customer.id)



  }
}
