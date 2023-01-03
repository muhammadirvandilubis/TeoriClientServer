/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmerzamannow.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import programmerzamannow.spring.core.data.Connection;
import programmerzamannow.spring.core.data.Server;

/**
 *
 * @author Vandi
 */

@Configuration
public class LifeCycleConfiguration {
    
    @Bean
    public Connection connection(){
        return new Connection();
    }
    
    // @Bean(initMethod = "start", destroyMethod = "stop")
    @Bean
    public Server server(){
        return new Server ();
    }
}
