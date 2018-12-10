package ru.hibernateRequires.mnj.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/",produces = APPLICATION_JSON_VALUE)
public class User_manConrtoller {
}
