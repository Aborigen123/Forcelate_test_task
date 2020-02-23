package com.example;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.domain.AuthenticationRequestDto;
import com.example.domain.LoginResponse;
import com.example.entity.User;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ForcelateHwApplicationTests {



	private MockMvc mockMVC;

	ObjectMapper om = new ObjectMapper();
	@Autowired
	private WebApplicationContext context;

	@Mock
	private UserService userService;
	

	@Before
	public void setUp() throws Exception {
		mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testRegistration() throws Exception {

		User user = new User("Hello", 4, "Victor", "pass");
		String jsonRequest = om.writeValueAsString(user);
		mockMVC.perform(post("/registration").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated());

		assertNotNull(user);
      
		doReturn(user).when(userService).findUserByEmail(user.getEmail()); 

		AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto(user.getEmail(),
				user.getPassword());
		String jsonRequestLogin = om.writeValueAsString(authenticationRequestDto);
		MvcResult result = mockMVC
				.perform(post("/login").content(jsonRequestLogin).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		LoginResponse response = om.readValue(resultContent, LoginResponse.class);

		assertNotNull(response);
		Assert.assertEquals(authenticationRequestDto.getEmail(), response.getEmail());

		mockMVC.perform(get("/select/color/blue").content(jsonRequestLogin)
				.contentType(MediaType.APPLICATION_JSON_VALUE).param("Authorization", "Bearer_" + response.getToken()))
				.andExpect(status().isFound()).andReturn();

	}

}
