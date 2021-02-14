package io.spring.mailsenderbizdem.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix="file")
@Setter
@Getter
public class FileUploadProperties {
    private String uploadDir;

}