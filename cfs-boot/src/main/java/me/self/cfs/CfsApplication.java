package me.self.cfs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = {"org.camunda.bpm", "me.self.cfs"})
public class CfsApplication {
    private static final Logger log = LoggerFactory.getLogger(CfsApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(CfsApplication.class, args);
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (path == null || "".equals(path)) {
            path = "/";
        }
        log.info("\n----------------------------------------------------------\n" +
                "\tApplication is running!\n" +
                "\tPort:\t" + port + "\n" +
                "\tPath:\t" + path + "\n" +
                "----------------------------------------------------------");
    }

}
