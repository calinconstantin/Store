package ro.calin.Store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.calin.Store.models.Product;
import ro.calin.Store.modelsDTO.CreateProductDTO;
import ro.calin.Store.modelsDTO.CreateProductResponseDTO;
import ro.calin.Store.repository.ProductRepository;
import ro.calin.Store.utils.Constants;
import ro.calin.Store.utils.Tools;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<String> CreateProduct(CreateProductDTO newProduct){

        ArrayList<String> response = new ArrayList<>();
//___________________FULL_NAME__________________________________________
        if(Tools.checkNullEmpty(newProduct.getFullName()))
            response.add(Constants.productFullNameNull);
        else
            if(Tools.checkLetterDigits(newProduct.getFullName()) && newProduct.getFullName().length()>3 && newProduct.getFullName().length()<20)
                response.add(Constants.productFullNameOK);
            else
                response.add(Constants.productFullNameNOK);
//___________________PRICE__________________________________________________
        if(Tools.checkNullEmpty(newProduct.getPrice()))
            response.add(Constants.productPriceNull);
        else
        if(Tools.checkDouble(newProduct.getPrice().toString()) && newProduct.getPrice().toString().length()>=3 && newProduct.getPrice().toString().length()<20)
            response.add(Constants.productPriceOK);
        else
            response.add(Constants.productPriceNOK);
//___________________STOCK________________________________________________
        if(Tools.checkNullEmpty(newProduct.getStock()))
            response.add(Constants.productStockNull);
        else
        if(Tools.checkDigits(Integer.toString(newProduct.getStock())) && newProduct.getStock()>=0 && Integer.toString(newProduct.getStock()).length()<20)
            response.add(Constants.productStockOK);
        else
            response.add(Constants.productStockNOK);

        if(response.get(0).equals(Constants.productFullNameOK) && response.get(1).equals(Constants.productPriceOK) && response.get(2).equals(Constants.productStockOK))
        {
            response.add(Constants.productRegistered);
            Product product = new Product();
            product.setFullName(newProduct.getFullName());
            product.setPrice(newProduct.getPrice());
            product.setStock(newProduct.getStock());
            productRepository.save(product);
        }
        else
            response.add(Constants.productNotRegistered);
    return response;
    }

    public String DeleteProduct(Long idProduct){
        for(Product thisProduct : productRepository.findAll() ){
            if(idProduct.equals(thisProduct.getId()))
            {
                thisProduct.setDeleted(true);
                productRepository.save(thisProduct);
                return Constants.productDeleted;
            }
        }return Constants.productNotDeleted;
    }

    public String UpdateProduct(Product updateProduct){
        if(productRepository.findById(updateProduct.getId()).isPresent())
        {   productRepository.save(updateProduct);
            return Constants.productUpdated;
        }
    return Constants.productNotUpdated;
    }

    public List<Product> ViewAll(){
        return productRepository.findAll();
    }
}
