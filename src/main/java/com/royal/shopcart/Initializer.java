package com.royal.shopcart;

import com.royal.shopcart.data.ProductRepository;
import com.royal.shopcart.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final ProductRepository prodRepo;

    @Override
    public void run(String... args) {

        Product badTicket = Product.builder()
                .name("Value Ticket")
                .price(2.99)
                .imgLink("https://previews.123rf.com/images/pixelrobot/pixelrobot1504/pixelrobot150400456/38260239-red-crumpled-admit-one-ticket-isolated-on-white-background-.jpg")
                .build();

        Product okayTicket = Product.builder()
                .name("Regular Ticket")
                .price(10.00)
                .imgLink("http://toptierbusiness.org/wp-content/uploads/carnival-king-pink-2-part-raffle-tickets-2000roll-2-part-raffle-tickets.jpg")
                .build();

        Product goodTicket = Product.builder()
                .name("VIP Ticket")
                .price(100.00)
                .imgLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYnedpm0nixwi2cPNcaRQJttMlMX21Ya4VBaruYgkKPci-j6YJng")
                .build();

        prodRepo.save(badTicket);
        prodRepo.save(okayTicket);
        prodRepo.save(goodTicket);

        prodRepo.findAll().forEach(prod -> System.out.println(prod));
    }
}
