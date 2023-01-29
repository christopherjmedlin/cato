package xyz.christophermedlin.cato;

import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.services.SmoothieService;

@SpringBootTest
@AutoConfigureMockMvc
public class SmoothieControllerTests {
    private static final String LIST_PATH = "$._embedded.smoothieList";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SmoothieService smoothieService;

    @BeforeEach
    public void init() {
        ArrayList<Smoothie> pageone = new ArrayList<>();
        Smoothie first = new Smoothie("0");
        pageone.add(first);
        for (int i = 1; i < 10; i++) {
            pageone.add(new Smoothie(Integer.toString(i)));
        }
        ArrayList<Smoothie> pagetwo = new ArrayList<>();
        pagetwo.add(new Smoothie("Apple"));
        
        when(smoothieService.findAll(PageRequest.of(0, 10)))
                .thenReturn(new PageImpl<>(pageone));
        when(smoothieService.findAll(PageRequest.of(1, 10)))
                .thenReturn(new PageImpl<>(pagetwo));
        when(smoothieService.findById((long) 1))
                .thenReturn(first);
    }

    private JsonPathResultMatchers listPath(String path) {
        return jsonPath(SmoothieControllerTests.LIST_PATH + path);
    }

    @Test
    public void shouldReturnFirstPageWhenNoParams() throws Exception {
        this.mockMvc.perform(get("/smoothies"))
                .andExpect(status().isOk())
                .andExpect(listPath("").isArray())
                .andExpect(listPath("[0].name").value("0"))
                .andExpect(listPath("[9].name").value("9"))
                .andExpect(listPath("[10]").doesNotExist());
    }

    @Test
    public void shouldReturnSecondPage() throws Exception {
        this.mockMvc.perform(get("/smoothies?page=1"))
                .andExpect(status().isOk())
                .andExpect(listPath("[0].name").value("Apple"))
                .andExpect(listPath("[1]").doesNotExist());
    }

    @Test
    public void shouldHaveSelfRef() throws Exception {
        this.mockMvc.perform(get("/smoothies/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$._links.self").exists())
            .andExpect(jsonPath("$._links.self.href").value(
                "http://localhost/smoothies/{id}"
            ));
    }

    @Test
    public void listShouldHaveSelfRefs() throws Exception {
        this.mockMvc.perform(get("/smoothies"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$._links.self").exists())
            .andExpect(listPath("[0]._links.self").exists());
    }

    @Test
    public void hasIngredientSearchLink() throws Exception {
        this.mockMvc.perform(get("/smoothies"))
            .andExpect(jsonPath("$._links.ingredientSearch").exists());
    }
}
