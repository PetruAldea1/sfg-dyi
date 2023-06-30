package petru.springframework.sfgdi.config;

import com.springframewok.pets.PetService;
import com.springframewok.pets.PetServiceFactory;
import org.springframework.context.annotation.*;
import petru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import petru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import petru.springframework.sfgdi.services.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {
    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }
    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
       return  petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService carPetService(PetServiceFactory petServiceFactory){
        return  petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    /*
    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }
    */

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
