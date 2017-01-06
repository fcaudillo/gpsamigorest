


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class AlarmaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmaApplication.class, args);
    }

    
    /*
    @Bean
    @Profile({"ALL", "MEX"})
    public PinpadDeviceLoader pinpadDeviceLoader() throws Exception {
    	return new PinpadDeviceLoader();
    }
    */
   
    
}
