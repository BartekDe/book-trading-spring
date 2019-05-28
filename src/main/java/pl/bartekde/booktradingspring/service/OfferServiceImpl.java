package pl.bartekde.booktradingspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bartekde.booktradingspring.dao.OfferDao;
import pl.bartekde.booktradingspring.entity.Offer;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferDao offerDao;

    @Autowired
    public OfferServiceImpl(OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    @Override
    @Transactional
    public Offer findByBookTitle(String bookTitle) {
        return offerDao.findByBookTitle(bookTitle);
    }

    @Override
    @Transactional
    public Offer findById(long id) {
        return offerDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Offer offer) {
        offerDao.save(offer);
    }
}
