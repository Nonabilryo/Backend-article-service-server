package nonabili.articleserviceserver.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "image")
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val idx: UUID = UUID.randomUUID(),
    @Column(name = "url", unique = true, nullable = false, length = 255)
    val url: String
)
