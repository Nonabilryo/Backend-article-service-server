package nonabili.articleserviceserver.repository

import nonabili.articleserviceserver.entity.Image
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ImageRepository: JpaRepository<Image, UUID> {
}