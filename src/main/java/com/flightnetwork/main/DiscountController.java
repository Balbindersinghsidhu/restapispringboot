package com.flightnetwork.main;

import com.flightnetwork.demo.api.APIName;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.flightnetwork.demo.service.DiscountService;

@RestController
public class DiscountController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(APIName.Discount)
    public String discount(@RequestParam(value="userType", required=true) String userType,@RequestParam(value="amount", required=true) String amount) {
        DiscountService ds=new DiscountService();
        Double amt=Double.valueOf(amount);
        Double data=ds.getDiscountAmount(userType, amt);
        return String.valueOf(data);
        
    }
}
