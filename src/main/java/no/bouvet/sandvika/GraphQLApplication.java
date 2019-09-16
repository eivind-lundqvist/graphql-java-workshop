package no.bouvet.sandvika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class GraphQLApplication
{
    public final TransactionTemplate transactionTemplate;

    @Autowired
    public GraphQLApplication(TransactionTemplate transactionTemplate)
    {
        this.transactionTemplate = transactionTemplate;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(GraphQLApplication.class, args);
    }
}
