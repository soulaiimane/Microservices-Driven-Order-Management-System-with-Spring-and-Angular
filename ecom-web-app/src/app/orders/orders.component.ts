import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit{
  orders!:any
  customerId !:number
  constructor(private http:HttpClient,private router:Router,private route:ActivatedRoute ) {
  this.customerId=this.route.snapshot.params['customerId'];
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/order-service/orders/search/byCustomerId?customerId="+this.customerId+"&projection=fullOrder").subscribe({
      next:value => {
        this.orders=value;
      },error:err => {
        err.message;
      }
    })
}

  getDetailsOrders(order: any) {
    this.router.navigateByUrl("/order-details/"+order.id)

  }
}
