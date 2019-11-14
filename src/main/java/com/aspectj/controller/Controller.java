package com.aspectj.controller;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller extends ControllerBase {

    @GetMapping
    public ResponseEntity<Integer> test() throws Exception {
        
        aspectSuperProtected();
        aspectInterfaceDefaultMethod();
        return ResponseEntity.ok(aspectPrivateMethod());
    }

    private Integer aspectPrivateMethod() throws Exception {
        return aspectProtectedMethod();
    }

    protected Integer aspectProtectedMethod() throws Exception {
        return aspectPrivateStaticFinalMethod();
    }

    private static final Integer aspectPrivateStaticFinalMethod() throws Exception {
        return aspectPublicStaticMethod();
    }

    public static Integer aspectPublicStaticMethod() throws Exception {
        StringUtils.isNotBlank("");
        return new Random().nextInt();
    }

}
