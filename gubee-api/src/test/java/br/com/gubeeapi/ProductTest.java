package br.com.gubeeapi;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.model.Stack;
import br.com.gubeeapi.domain.model.TargetMarket;
import br.com.gubeeapi.domain.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductTest extends AbstractProductTest{
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	protected ProductService productService;
		
	@Test
	public void getProductsList() throws Exception {
	   String uri = "/produtos";
	 
	   Product product = new Product();
	   product.setId(1L);
	   product.setProductName("Daniel job");
	   product.setDescription("Carrinho de compras integrador");
  
	   Stack stack = new Stack();
	   stack.setId(1L);
	   stack.setName("PHP 7");		   
	   Stack stack2 = new Stack();
	   stack2.setId(2L);
	   stack2.setName("Kibana");	   		   
	   List<Stack> stacks = new ArrayList<>();
	   stacks.add(stack);
	   stacks.add(stack2);   
		   
	   product.setStack(stacks);
	   
	   TargetMarket targetMarket = new TargetMarket();
	   targetMarket.setId(1L);
	   targetMarket.setName("Ecommerce");
	   List<TargetMarket> tms = new ArrayList<>();
	   tms.add(targetMarket);
	   
	   product.setTargetMarket(tms);
	   
	   List<Product> products = new ArrayList<Product>();
	   products.add(product);
	   	
       given(productService.listarProdutos()).willReturn(products);
       
       this.mockMvc.perform(get(uri))
	       .andExpect(status().isOk())
	       .andExpect(content().json("[{'id': 1,'productName': 'Daniel job','description': 'Carrinho de compras integrador','stack': [{'id':1, 'name': 'PHP 7'}, {'id':2, 'name': 'Kibana'}], 'targetMarket':[{'id':1, 'name': 'Ecommerce'}]}]"));
	}
	
	@Test
	public void newProduct() throws Exception {
	   //TODO test com post
	}
}
