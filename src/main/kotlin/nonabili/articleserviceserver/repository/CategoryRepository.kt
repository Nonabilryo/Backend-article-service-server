package nonabili.articleserviceserver.repository

import nonabili.articleserviceserver.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CategoryRepository: JpaRepository<Category, UUID> {
    fun findCategoryByName(name: String): Category?
}