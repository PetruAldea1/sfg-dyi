package petru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES","default"})
public class I18nSpanishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "HOLLA MUNDO- ES";
    }
}
