package ro.calin.Store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.calin.Store.models.Product;
import ro.calin.Store.modelsDTO.CreateProductDTO;
import ro.calin.Store.modelsDTO.CreateProductResponseDTO;
import ro.calin.Store.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public CreateProductResponseDTO CreateProduct(CreateProductDTO newProduct){
            CreateProductResponseDTO response = new CreateProductResponseDTO();

        if(newProduct.getFullName()==null || newProduct.getFullName().isEmpty())
            response.setFullNameNull(true);
        else
        {
                if(newProduct.getFullName().length()>=6 && newProduct.getFullName().length()<=20)
                {
                    if(!newProduct.getFullName().matches("[a-zA-Z]+") ||
                            !newProduct.getFullName().matches("[0-9]+") )
                        response.setFullNameNok(true);
                }
                else
                    response.setFullNameNok(true);
        }
        if(newProduct.getPrice()==null )
            response.setPriceNull(true);
        else
        {
            if(0<newProduct.getPrice() && newProduct.getPrice()<=999.99)
            {
                if(!newProduct.getPrice().toString().matches("[0-9]+"))
                    response.setPriceNok(true);
            }
            else
                response.setPriceNok(true);
        }

        if(newProduct.getStock()!=null )
            response.setStockNull(true);
        else
        {
            if(newProduct.getStock()>0 && newProduct.getStock()<=999.99)
            {
                if(!newProduct.getStock().toString().matches("[0-9]+"))
                    response.setStockNok(true);
            }
            else
                response.setStockNok(true);
        }

        return response;
    }

    public boolean DeleteProduct(Long idProduct){
        for(Product thisProduct : productRepository.findAll() ){
            if(idProduct.equals(thisProduct.getId()))
            {
                thisProduct.setDeleted(true);
                productRepository.save(thisProduct);
                return true;
            }
        }
    return false;
    }

    public boolean UpdateProduct(Product updateProduct){
        if(productRepository.findById(updateProduct.getId()).isPresent())
        {   productRepository.save(updateProduct);
            return true;
        }
    return false;
    }

    public List<Product> ViewAll(){
        List<Product> list = new ArrayList<Product>(productRepository.findAll());
        return list;
    }

}
