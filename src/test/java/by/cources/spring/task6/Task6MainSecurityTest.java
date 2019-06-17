package by.cources.spring.task6;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.Filter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class Task6MainSecurityTest {

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private Filter springSecurityFilterChain;

  private MockMvc mvc;

  @Before
  public void setup() {
    mvc = MockMvcBuilders
        .webAppContextSetup(context)
        .addFilters(springSecurityFilterChain)
        .build();
  }

  @Test
  @WithMockUser
  public void test1() throws Exception {
    mvc
        .perform(get("/book/list"))
        .andExpect(status().is3xxRedirection())
        .andExpect(unauthenticated());
  }

  @Test
  @WithMockUser
  public void test2() throws Exception {
    mvc
        .perform(get("/book/list").with(user("user").roles("USER")))
        .andExpect(status().is2xxSuccessful())
        .andExpect(authenticated().withUsername("user"));
  }

  @Test
  @WithMockUser
  public void test3() throws Exception {
    mvc
        .perform(get("/book/edit/1").with(user("user").roles("USER")))
        .andExpect(status().isForbidden())
        .andExpect(authenticated().withUsername("user"));
  }

  @Test
  @WithMockUser
  public void test4() throws Exception {
    mvc
        .perform(get("/book/edit/1").with(user("user").roles("ADMIN")))
        .andExpect(status().is2xxSuccessful())
        .andExpect(authenticated().withUsername("user"));
  }

  @Test
  @WithMockUser
  public void test5() throws Exception {
    mvc
        .perform(get("/logout").with(user("user").roles("ADMIN")))
        .andExpect(status().is3xxRedirection())
        .andExpect(unauthenticated());
  }

  @Test
  public void test6() throws Exception {
    mvc
        .perform(formLogin("/login")
            .user("username", "user")
            .password("password", "1234567"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/login?error"))
        .andExpect(unauthenticated());
  }

  @Test
  public void test7() throws Exception {
    mvc
        .perform(formLogin("/login")
            .user("username", "user")
            .password("password", "123456"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/book/list"))
        .andExpect(authenticated().withUsername("user"));
  }

  @Test
  public void test8() throws Exception {
    mvc
            .perform(get("/book/delete/1").with(user("user").roles("ADMIN")))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/book/list"))
            .andExpect(authenticated().withUsername("user"));
  }

  @Test
  public void test9() throws Exception {
    mvc
            .perform(get("/book/delete/1").with(user("user").roles("USER")))
            //.andExpect(status().is4xxClientError())
            //аналогично is4xxClientError = isForbidden
            .andExpect(status().isForbidden())
            .andExpect(authenticated().withUsername("user"));
  }
}