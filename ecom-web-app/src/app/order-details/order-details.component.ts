import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit{
  orderDetails!:any
  orderId !:number
  constructor(private http:HttpClient,private router:Router,private route:ActivatedRoute ) {
    this.orderId=this.route.snapshot.params['orderId'];
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/order-service/orderDetails/"+this.orderId).subscribe({
      next:value => {
        this.orderDetails=value;
      },error:err => {
        err.message;
      }
    })
  }
}
