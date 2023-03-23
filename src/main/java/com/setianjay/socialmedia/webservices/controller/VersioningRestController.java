package com.setianjay.socialmedia.webservices.controller;

import com.setianjay.socialmedia.webservices.model.response.UserV1Response;
import com.setianjay.socialmedia.webservices.model.response.UserV2Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VersioningRestController {

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<UserV1Response>> urlVersion1(){
        List<UserV1Response> users = new ArrayList<>(){{
            add(new UserV1Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24)));
            add(new UserV1Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16)));
            add(new UserV1Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5)));
            add(new UserV1Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11)));
        }};

        return ResponseEntity.ok(users);
    }

    @GetMapping("/api/v2/users")
    public ResponseEntity<List<UserV2Response>> urlVersion2(){
        List<UserV2Response> users = new ArrayList<>(){{
            add(new UserV2Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24), 22));
            add(new UserV2Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16), 22));
            add(new UserV2Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5), 22));
            add(new UserV2Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11), 22));
        }};

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/api/users", params = {"version=1"})
    public ResponseEntity<List<UserV1Response>> paramVersion1(){
        List<UserV1Response> users = new ArrayList<>(){{
            add(new UserV1Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24)));
            add(new UserV1Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16)));
            add(new UserV1Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5)));
            add(new UserV1Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11)));
        }};

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/api/users", params = {"version=2"})
    public ResponseEntity<List<UserV2Response>> paramVersion2(){
        List<UserV2Response> users = new ArrayList<>(){{
            add(new UserV2Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24), 22));
            add(new UserV2Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16), 22));
            add(new UserV2Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5), 22));
            add(new UserV2Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11), 22));
        }};

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/api/users/header", headers = {"X-Api-Version=1"})
    public ResponseEntity<List<UserV1Response>> headerCustomVersion1(){
        List<UserV1Response> users = new ArrayList<>(){{
            add(new UserV1Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24)));
            add(new UserV1Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16)));
            add(new UserV1Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5)));
            add(new UserV1Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11)));
        }};

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/api/users/header", headers = {"X-Api-Version=2"})
    public ResponseEntity<List<UserV2Response>> headerCustomVersion2(){
        List<UserV2Response> users = new ArrayList<>(){{
            add(new UserV2Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24), 22));
            add(new UserV2Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16), 22));
            add(new UserV2Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5), 22));
            add(new UserV2Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11), 22));
        }};

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/api/users/header-accept", produces = {"application/com.setianjay.app.v1+json"})
    public ResponseEntity<List<UserV1Response>> headerAcceptVersion1(){
        List<UserV1Response> users = new ArrayList<>(){{
            add(new UserV1Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24)));
            add(new UserV1Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16)));
            add(new UserV1Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5)));
            add(new UserV1Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11)));
        }};

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/api/users/header-accept", produces = {"application/com.setianjay.app.v2+json"})
    public ResponseEntity<List<UserV2Response>> headerAcceptVersion2(){
        List<UserV2Response> users = new ArrayList<>(){{
            add(new UserV2Response(1L, "setyarto", LocalDate.of(1962, Month.JULY, 24), 22));
            add(new UserV2Response(2L, "sudaryati", LocalDate.of(1972, Month.OCTOBER, 16), 22));
            add(new UserV2Response(3L, "gurindo sekti", LocalDate.of(1997, Month.JUNE, 5), 22));
            add(new UserV2Response(4L, "hari setiaji", LocalDate.of(2000, Month.NOVEMBER, 11), 22));
        }};

        return ResponseEntity.ok(users);
    }
}
