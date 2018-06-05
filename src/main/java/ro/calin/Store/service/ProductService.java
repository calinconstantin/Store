package ro.calin.Store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.calin.Store.models.Product;
import ro.calin.Store.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean createProduct(Product product){

        if(product.getFullName()!=null)
            if(product.getPrice()!=0)
                if(product.getStock()!=0)
                {
                    productRepository.save(product);
                    return true;
                }
    return false;
    }

    public boolean deleteProduct(Product product){
        boolean isDeleted = false;
        for(Product thisProduct : productRepository.findAll() ){
            if(product.getId().equals(thisProduct.getId()))
            {
                product.setDeleted(false);
                productRepository.save(product);
                isDeleted=true;
            }
        }
     return isDeleted;
    }

}
