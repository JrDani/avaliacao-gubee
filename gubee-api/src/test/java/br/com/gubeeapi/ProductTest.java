package br.com.gubeeapi;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.gubeeapi.domain.model.Product;
import br.com.gubeeapi.domain.repository.StackRepository;
import br.com.gubeeapi.domain.repository.TargetMarketRepository;
import br.com.gubeeapi.domain.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductTest extends AbstractProductTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	protected ProductService productService;
	
	@MockBean
	protected StackRepository stackRepository;
	
	@MockBean
	protected TargetMarketRepository targetMarketRepository;

	@Test
	public void getProductsList() throws Exception {
		String uri = "/produtos";

		buildProdutos();

		given(productService.listarProdutos()).willReturn(AbstractProductTest.PRODUCTS);

		this.mockMvc.perform(get(uri))
		.andExpect(status().isOk())
		.andExpect(content().json(
				"[{'id': 1,'productName': 'Daniel job','description': 'Carrinho de compras integrador','stack': [{'id':1, 'name': 'PHP 7'}, {'id':2, 'name': 'Kibana'}], 'targetMarket':[{'id':1, 'name': 'Ecommerce'}]}]"));
	}

	@Test
	public void newProduct() throws Exception {
		String uri = "/produtos";

		Product product = buildProduct();

		when(this.productService.cadastrarProduto(product)).thenReturn(product);

		this.mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).content(
				"{\"productName\": \"Daniel job\",\"description\": \"Carrinho de compras integrador\",\"stack\": [{\"id\":1, \"name\": \"PHP 7\"}, {\"id\":2, \"name\": \"Kibana\"}], \"targetMarket\":[{\"id\":1, \"name\": \"Ecommerce\"}]}"))
				.andExpect(status().isCreated());

	}
}
