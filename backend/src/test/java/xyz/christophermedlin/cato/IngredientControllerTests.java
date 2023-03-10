package xyz.christophermedlin.cato;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.services.IngredientService;

@SpringBootTest
@AutoConfigureMockMvc
public class IngredientControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService ingredientService;

    @BeforeEach
    public void init() {
        ArrayList<Ingredient> pageone = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pageone.add(new Ingredient(Integer.toString(i)));
        }
        ArrayList<Ingredient> pagetwo = new ArrayList<>();
        pagetwo.add(new Ingredient("Apple"));

        when(ingredientService.findAll(PageRequest.of(0, 10)))
                .thenReturn(new PageImpl<>(pageone));
        when(ingredientService.findAll(PageRequest.of(1, 10)))
                .thenReturn(new PageImpl<>(pagetwo));
        when(ingredientService.findByNameContains("apple", PageRequest.of(0, 10)))
                .thenReturn(new PageImpl<>(pagetwo));
    }

    @Test
    public void shouldReturnFirstPageWhenNoParams() throws Exception {
        this.mockMvc.perform(get("/ingredients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("0"))
                .andExpect(jsonPath("$[9].name").value("9"))
                .andExpect(jsonPath("$[10]").doesNotExist());
    }

    @Test
    public void shouldReturnSecondPage() throws Exception {
        this.mockMvc.perform(get("/ingredients?page=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Apple"))
                .andExpect(jsonPath("$[1]").doesNotExist());
    }

    @Test
    public void nameParameterWorks() throws Exception {
        this.mockMvc.perform(get("/ingredients?name=apple"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Apple"));
    }
}
