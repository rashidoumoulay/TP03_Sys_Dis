package oumoulay.net.tp03;

import oumoulay.net.tp03.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import oumoulay.net.tp03.repositories.PatientRepository;

import java.util.Date;

@SpringBootApplication
public class Tp03Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp03Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Hassan" , new Date() , false , 34));
        patientRepository.save(new Patient(null,"Hanane" , new Date() , true , 45));
        patientRepository.save(new Patient(null,"Said" , new Date() , false , 50));

        patientRepository.save(new Patient(null,"Houssam" , new Date() , true , 500));
        patientRepository.save(new Patient(null,"Nabil" , new Date() , true , 150));
        patientRepository.save(new Patient(null,"Zouhir" , new Date() , false , 430));
    }
}
