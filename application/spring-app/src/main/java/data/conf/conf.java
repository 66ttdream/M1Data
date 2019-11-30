package data.conf;

import data.controller.TimerSynDataControl;
import data.spring.conf.SpringConf;
import data.usecase.SaveSynParameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class conf {
    public  final SpringConf config = new SpringConf();

    @Bean
    public  SaveSynParameter saveSynParameter(){
        return config.saveSynParameter();
    }

    @Bean
    public TimerSynDataControl timerSynDataControl(){
        return new TimerSynDataControl(saveSynParameter());
    }


}
