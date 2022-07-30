package com.andreanbuhchev.bulgarian_racing_community.scheduler;

import com.andreanbuhchev.bulgarian_racing_community.service.ShoppingCartService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled",matchIfMissing = true)
public class SchedulerConfig {

   private final ShoppingCartService shoppingCartService;

    public SchedulerConfig(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Scheduled(cron = "00 00 04 * * *")
    void deleteUsersShoppingCartItems(){
        shoppingCartService.deleteAllShoppingCartItems();
    }
}
