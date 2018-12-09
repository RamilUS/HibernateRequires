package ru.hibernateRequires.mnj.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hibernateRequires.mnj.organization.service.OrganizationService;
import ru.hibernateRequires.mnj.organization.view.OrganizationView;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class OrganizationConrtoller {

    /** Контроллер для объекта Organization
     * включает в себя следующее api:
     * /list - возвращает список всех существующих организаций
     */
    @RestController
    @RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
    public class OrganizationController {

        private final OrganizationService organizationService;

        /**
         * Создаём объект OrganizationService, который будет обрабатывать запросы
         */
        @Autowired
        public OrganizationController(OrganizationService organizationService){
            this.organizationService = organizationService;
        }

        /**
         * Блок для /list, возвращает список организаций List<Organization>
         */
        @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "POST")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Success", response = String.class),
                @ApiResponse(code = 404, message = "Not Found"),
                @ApiResponse(code = 500, message = "Failure")})
        @PostMapping(value = "/list", consumes = APPLICATION_JSON_VALUE)
        public Object listUsers() {
            List<OrganizationView> views;
            try {
                views = organizationService.organization();
            }
            catch (SQLException e){
                return "{\"error\":"+"{Ошибка при получении списка организаций "+e.getMessage()+"}";
            }
            if (views == null) return "{\"error\":\"Список организаций пустой\"}";
            return views;
        }
    }
}

