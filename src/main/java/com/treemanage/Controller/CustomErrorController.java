package com.treemanage.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CustomErrorController implements ErrorController {
    // @GetMapping("/Error")
    // public String handleError(HttpServletRequest request,Model model) {
    //     String errorPage = "Error"; // default

    //     Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    //     if (status != null) {
    //         Integer statusCode = Integer.valueOf(status.toString());

    //         if (statusCode == HttpStatus.NOT_FOUND.value()) {
    //             // handle HTTP 404 Not Found error
    //             model.addAttribute("status", status);
    //             errorPage = "Error";

    //         } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
    //             // handle HTTP 403 Forbidden error
    //             model.addAttribute("status", status);
    //             errorPage = "Error";

    //         } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
    //             // handle HTTP 500 Internal Server 
    //             model.addAttribute("status", status);
    //             errorPage = "Error";

    //         }
    //     }
    //     return errorPage;
    // }
}
