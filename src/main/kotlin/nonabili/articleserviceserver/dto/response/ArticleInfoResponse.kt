package nonabili.articleserviceserver.dto.response

import nonabili.articleserviceserver.entity.Image
import java.util.Date

data class ArticleInfoResponse(
    val title: String,
    val images: List<Image>,
    val writer: String, // writerIdx
    val category: String,
    val description: String,
    val price: Long,
    val rentalType: String,
    val createdAt: Date,
    val like: Int
)
