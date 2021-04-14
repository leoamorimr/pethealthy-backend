package br.com.leoamorimr.pethealthy.pethealthybackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;

@SpringBootApplication
public class PethealthyBackendApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(PethealthyBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    }

}
