package org.soulaimane.customerservice.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class CustomerConfigTest {
    @Value("${global.params.p1}")
    String p1;
    @Value("${global.params.p2}")
    String p2;
    @Value("${customer.params.x}")
    String x;
    @Value("${customer.params.y}")
    String y;
    @GetMapping("/params")
    public Map <String,String> params(){
        return Map.of("p1",p1 ,"p2",p2,"x",x,"y",y);
    }


}
