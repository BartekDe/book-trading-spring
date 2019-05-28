package pl.bartekde.booktradingspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bartekde.booktradingspring.entity.Offer;
import pl.bartekde.booktradingspring.service.OfferService;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("/offer")
public class OfferRestController {

    private OfferService offerService;

    @Autowired
    public OfferRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{offerId}")
    public Offer showOffer(@PathVariable long offerId) {
        return offerService.findById(offerId);
    }
}
