package nonabili.articleserviceserver.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.io.FileInputStream

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(RestDocumentationExtension::class, SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ArticleControllerTest {
    var mockMvc: MockMvc? = null
    val log = LoggerFactory.getLogger(javaClass)

    private val objectMapper = ObjectMapper()

    @Autowired
    private val wac: WebApplicationContext? = null

    @BeforeEach
    fun setUp(restDocumentation: RestDocumentationContextProvider?) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac!!)
            .apply<DefaultMockMvcBuilder>(MockMvcRestDocumentation.documentationConfiguration(restDocumentation))
            .build()
    }

    @Test
    fun getSuggestArticle() {
        mockMvc?.perform(
            get("/article?page=0")
                .contentType(MediaType.APPLICATION_JSON)
        )
            ?.andExpect(MockMvcResultMatchers.status().isOk)
            ?.andDo(document("getSuggest/success"))
    }

    @Test
    fun postArticle() {
        val userId = "ansrkdls"
        val fileInputStream = FileInputStream("src/test/images/eye.jpg")
        val content = MockMultipartFile("images", "eye.jpg", "image/jpg", fileInputStream)
        val builder = MockMvcRequestBuilders
            .multipart("/article")
            .file(content)
            .param("title", "테스트 글")
            .param("category", "테스트")
            .param("description", "테스트 입니다.")
            .param("price", "100000")
            .param("rentalType", "3")
            .header("userId", userId)
        mockMvc?.perform(builder)
            ?.andExpect(MockMvcResultMatchers.status().isOk)
            ?.andDo(MockMvcResultHandlers.print())
            ?.andDo(document("postArticle/success"))
    }

    @Test
    fun getArticleInfo() {
        val articleIdx = "1b585769-3f01-4cb6-ba54-d0c30b95cb1b"
        mockMvc?.perform(
            get("/article/$articleIdx")
                .contentType(MediaType.APPLICATION_JSON)
        )
            ?.andExpect(MockMvcResultMatchers.status().isOk)
            ?.andDo(document("getArticleInfo/success"))
    }

    @Test
    fun postLike() {
        val articleIdx = "1b585769-3f01-4cb6-ba54-d0c30b95cb1b"
        val userId = "ansrkdls"
        mockMvc?.perform(
            post("/article/$articleIdx/like")
                .contentType(MediaType.APPLICATION_JSON)
                .header("userId", userId)
        )
            ?.andExpect(MockMvcResultMatchers.status().isOk)
            ?.andDo(document("postLike/success"))
    }

    @Test
    fun deleteLike() {
        val articleIdx = "1b585769-3f01-4cb6-ba54-d0c30b95cb1b"
        val userId = "ansrkdls"
        mockMvc?.perform(
            delete("/article/$articleIdx/like")
                .contentType(MediaType.APPLICATION_JSON)
                .header("userId", userId)
        )
            ?.andExpect(MockMvcResultMatchers.status().isOk)
            ?.andDo(document("deleteLike/success"))
    }
}