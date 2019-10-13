package soundsystem.javacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import soundsystem.CDPlayer;
import soundsystem.CompactDisc;
import soundsystem.SgtPeppers;

@Configuration
public class CDPlayerConfig {

    @Bean("lonelyHeartsClub")
    public CompactDisc setPeppers(){
        return new SgtPeppers();
    }

    @Bean
    public CompactDisc randomHeartsClubBand(){
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(setPeppers());
    }

    @Bean
    public CDPlayer anotherCDPlayer(){
        return new CDPlayer(setPeppers());
    }
}
