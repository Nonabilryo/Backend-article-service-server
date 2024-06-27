package nonabili.articleserviceserver.util.error

import org.springframework.http.HttpStatus

enum class ErrorState(val status: HttpStatus = HttpStatus.OK, val message: String) {

    ERROR_FORMAT(HttpStatus.BAD_REQUEST, "It's test"),

    ID_IS_ALREADY_USED(HttpStatus.BAD_REQUEST, "Id is already used"),
    NAME_IS_ALREADY_USED(HttpStatus.BAD_REQUEST, "Name is already used"),
    TELL_IS_ALREADY_USED(HttpStatus.BAD_REQUEST, "Tell is already used"),
    EMAIL_IS_ALREADY_USED(HttpStatus.BAD_REQUEST, "Email is already used"),

    DIFFERENT_USER(HttpStatus.FORBIDDEN, "User is not ower"),

    NOT_FOUND_ID(HttpStatus.NOT_FOUND, "Not found Id"),
    NOT_FOUND_USERNAME(HttpStatus.NOT_FOUND, "Not found user"),
    NOT_FOUND_FOLLOW(HttpStatus.NOT_FOUND, "Not Found Follow"),
    NOT_FOUND_ARTICLE(HttpStatus.NOT_FOUND, "Not found Article"),
    NOT_FOUND_LIKE(HttpStatus.NOT_FOUND, "Not found Like"),

    ILLEGAL_ARTICLE(HttpStatus.BAD_REQUEST, "Article is not legal"),
    ILLEGAL_RENTALTYPE(HttpStatus.BAD_REQUEST, "Rentaltype is not legal"),

    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "Wrong password"),

    NOT_VERIFED_EMAIL(HttpStatus.BAD_REQUEST, "Email not verifed"),
    NOT_VERIFED_TELL(HttpStatus.BAD_REQUEST, "Tell not verifed"),

    AREADY_FOLLOWED(HttpStatus.BAD_REQUEST, "Aready followed"),
    AREADY_LIKED(HttpStatus.BAD_REQUEST, "Aready liked")
}