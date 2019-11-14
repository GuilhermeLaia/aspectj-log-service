package com.aspectj.controller;

import java.util.Random;

public interface IController {

    default Integer aspectInterfaceDefaultMethod() {
        return new Random().nextInt();
    }

}
