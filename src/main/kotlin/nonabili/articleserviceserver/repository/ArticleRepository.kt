package nonabili.articleserviceserver.repository

import nonabili.articleserviceserver.entity.Article
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Date
import java.util.UUID

@Repository
interface ArticleRepository: JpaRepository<Article, UUID> {
    fun findArticleByIdx(idx: UUID): Article?

    @Query("SELECT a FROM Article a WHERE a.createdAt >= :createdAt ORDER BY SIZE(a.like) DESC")
    fun findArticlesByCreatedAtAfterOrderByLikeDesc(  // todo without category and like
        @Param("createdAt") createdAt: Date,
        pageable: Pageable
    ): Page<Article>


}