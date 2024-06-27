package nonabili.articleserviceserver.util.error

class CustomError(val reason: ErrorState): RuntimeException(reason.message)