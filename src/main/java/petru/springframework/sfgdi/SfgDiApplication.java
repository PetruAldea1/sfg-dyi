package petru.springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import petru.springframework.sfgdi.controllers.*;
@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = (PetController) ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");

        // PetController petController1
        System.out.println(petController.whichPetIsTheBest());


        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("-------------Primary Bean");
        System.out.println(myController.sayHello());

        //Spring Dependency Injection
        System.out.println("------Property");
        PropertyInjectedController propertyInjectedController = (
                PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("------Setter");
        SetterInjectedController setterInjectedController =
                (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("------Constructor");
        ConstructorInjectedController constructorInjectedController =
                (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

    }

}
