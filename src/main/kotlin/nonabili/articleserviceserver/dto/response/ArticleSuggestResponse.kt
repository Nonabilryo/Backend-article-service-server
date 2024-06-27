package nonabili.articleserviceserver.dto.response

import nonabili.articleserviceserver.entity.Image
import nonabili.articleserviceserver.entity.RentalType
import java.util.Date

data class ArticleSuggestResponse(
    val idx: String,
    val title: String,
    val price: Long,
    val rentalType: String,
    val image: Image,
    val createdAt: Date,
)
