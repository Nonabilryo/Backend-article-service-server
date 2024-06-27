package nonabili.articleserviceserver.controller

import nonabili.articleserviceserver.dto.request.ArticlePostRequest
import nonabili.articleserviceserver.service.ArticleService
import nonabili.articleserviceserver.util.ResponseFormat
import nonabili.articleserviceserver.util.ResponseFormatBuilder
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/article")
class ArticleController(val articleService: ArticleService) {
    @GetMapping("/page/{page}") // todo gateway
    fun getSuggestArticle(@PathVariable page: Int): ResponseEntity<ResponseFormat<Any>> {
        val result = articleService.getSuggestArticle(page)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.build(result))
    }
    @PostMapping(consumes = ["multipart/form-data"])
    fun postArticle(@RequestHeader requestHeaders: HttpHeaders, request: ArticlePostRequest): ResponseEntity<ResponseFormat<Any>> {
        val userIdx = requestHeaders.get("userIdx")!![0]
        articleService.postArticle(request, userIdx)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.noData())
    }
    @GetMapping("/{articleIdx}")  // todo 최근 본거 저장 gateway
    fun getArticleInfo(@PathVariable articleIdx: String): ResponseEntity<ResponseFormat<Any>> {
        val result = articleService.getArticleInfo(articleIdx)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.build(result))
    }

    @DeleteMapping("/{articleIdx}")
    fun deleteArticle(
        @RequestHeader requestHeaders: HttpHeaders,
        @PathVariable articleIdx: String
    ): ResponseEntity<ResponseFormat<Any>> {
        val userIdx = requestHeaders.get("userIdx")!![0]
        articleService.deleteArticle(articleIdx, userIdx)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.noData())
    }

    @GetMapping("/{articleIdx}/liked")
    fun getLiked(@PathVariable articleIdx: String, @RequestHeader requestHeaders: HttpHeaders): ResponseEntity<ResponseFormat<Any>> {
        val userIdx = requestHeaders.get("userIdx")!![0]
        val result = articleService.getLiked(articleIdx, userIdx)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.build(result))
    }
    @PostMapping("/{articleIdx}/like")
    fun postLike(@PathVariable articleIdx: String, @RequestHeader requestHeaders: HttpHeaders): ResponseEntity<ResponseFormat<Any>> {
        val userIdx = requestHeaders.get("userIdx")!![0]
        articleService.postLike(articleIdx, userIdx)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.noData())
    }
    @DeleteMapping("/{articleIdx}/like")
    fun deleteLike(@PathVariable articleIdx: String, @RequestHeader requestHeaders: HttpHeaders): ResponseEntity<ResponseFormat<Any>> {
        val userIdx = requestHeaders.get("userIdx")!![0]
        articleService.deleteLike(articleIdx, userIdx)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.noData())
    }

    @GetMapping("/articleIdxToWriterIdx/{articleIdx}")
    fun getWriterIdxByArticleIdx(@PathVariable articleIdx: String): ResponseEntity<ResponseFormat<Any>> {
        val result = articleService.getWriterIdxByArticleIdx(articleIdx)
        return ResponseEntity.ok(ResponseFormatBuilder { message = "success" }.build(result))
    }

}