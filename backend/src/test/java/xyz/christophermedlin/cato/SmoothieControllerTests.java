package xyz.christophermedlin.cato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import xyz.christophermedlin.cato.entities.Ingredient;
import xyz.christophermedlin.cato.entities.Smoothie;
import xyz.christophermedlin.cato.services.IngredientService;
import xyz.christophermedlin.cato.services.SmoothieService;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SmoothieControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SmoothieService smoothieService;

    @BeforeEach
    public void init() {
        ArrayList<Smoothie> pageone = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            pageone.add(new Smoothie(Integer.toString(i)));
        }
        ArrayList<Smoothie> pagetwo = new ArrayList<>();
        pagetwo.add(new Smoothie("Apple"));

        when(smoothieService.findAll(PageRequest.of(0, 10)))
                .thenReturn(pageone);
        when(smoothieService.findAll(PageRequest.of(1, 10)))
                .thenReturn(pagetwo);
    }

    @Test
    public void shouldReturnFirstPageWhenNoParams() throws Exception {
        this.mockMvc.perform(get("/smoothies"))
                //.andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("0"))
                .andExpect(jsonPath("$[9].name").value("9"))
                .andExpect(jsonPath("$[10]").doesNotExist());
    }

    @Test
    public void shouldReturnSecondPage() throws Exception {
        this.mockMvc.perform(get("/smoothies?page=1"))
                //.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Apple"))
                .andExpect(jsonPath("$[1]").doesNotExist());
    }

    @Test
    public void shouldReturnEmptyThirdPage() throws Exception {
        this.mockMvc.perform(get("/smoothies?page=2"))
                //.andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
