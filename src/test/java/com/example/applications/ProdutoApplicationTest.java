package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProdutoApplicationTest {
    @InjectMocks
    ProductApplication productApplication;

    @Mock
    ProductService productService;
    @Test
    public void testAtualizarImagemNoServiceCorretamente(){
        Product product = Mockito.any(Product.class);
        productApplication.update(1,product);
        Mockito.verify(productService,Mockito.times(1)).update(product);
    }

    @Test
    public void testSalvarImagemNoServiceCorretamente(){
        Product product = Mockito.mock(Product.class);
        Mockito.when(productService.save(product)).thenReturn(true);
        productApplication.append(product);
        Mockito.verify(productService, Mockito.times(1)).save(product);
    }

    @Test
    public void testRemoverImagemNoServiceCorretamente(){
        productApplication.remove(1);
        Mockito.verify(productService,Mockito.times(1)).remove(Mockito.any(Integer.class));
    }

    
}

