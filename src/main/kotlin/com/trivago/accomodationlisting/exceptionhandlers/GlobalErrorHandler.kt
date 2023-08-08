package com.trivago.accomodationlisting.exceptionhandlers

import com.trivago.accomodationlisting.exceptions.HotelierNotValidException
import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@Component
@ControllerAdvice
class GlobalErrorHandler: ResponseEntityExceptionHandler() {


     companion object: KLogging()

    @ExceptionHandler(HotelierNotValidException::class)
    fun handleHotelierNotValidExceptions(ex: HotelierNotValidException, request: WebRequest): ResponseEntity<Any> {

        logger.info("An error occurred here ${ex.message}")

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.message)
    }


    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any>{

        logger.info("An error occurred here ${ex.message}")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.message)
    }
}
