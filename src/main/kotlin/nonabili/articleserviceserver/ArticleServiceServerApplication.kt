package nonabili.articleserviceserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = ["nonabili.articleserviceserver.client"])
class ArticleServiceServerApplication

fun main(args: Array<String>) {
    runApplication<ArticleServiceServerApplication>(*args)
}
