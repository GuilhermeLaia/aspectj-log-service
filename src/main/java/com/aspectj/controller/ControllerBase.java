package com.aspectj.controller;

import java.util.Random;

public abstract class ControllerBase implements IController {

    protected void aspectSuperProtected() {
        aspectSuperPrivateMethod();
    }

    private Integer aspectSuperPrivateMethod() {
        return aspectSuperProtectedMethod();
    }

    protected Integer aspectSuperProtectedMethod() {
        return aspectSuperPrivateStaticFinalMethod();
    }

    private static final Integer aspectSuperPrivateStaticFinalMethod() {
        return aspectSuperPublicStaticMethod();
    }

    public static Integer aspectSuperPublicStaticMethod() {
        return new Random().nextInt();
    }

}
