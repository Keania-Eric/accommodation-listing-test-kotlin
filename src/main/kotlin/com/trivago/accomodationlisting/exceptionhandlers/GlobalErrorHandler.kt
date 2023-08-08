package com.trivago.accomodationlisting.exceptionhandlers

import com.trivago.accomodationlisting.exceptions.HotelierNotValidException
import com.trivago.accomodationlisting.exceptions.InvalidArgumentException
import com.trivago.accomodationlisting.exceptions.ItemNotFoundException
import jakarta.validation.ConstraintViolationException
import mu.KLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@Component
@ControllerAdvice
class GlobalErrorHandler: ResponseEntityExceptionHandler() {


     companion object: KLogging()

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {

        logger.info("MethodArgumentNotValidException observed: ${ex.message}", ex)
        val errors = ex.bindingResult.allErrors.map{
                error -> error.defaultMessage!!
        }.sorted()

        logger.info("errors $errors")

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.joinToString(", ") { it})

    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationExceptions(ex: ConstraintViolationException): ResponseEntity<Any> {
        val errors = ex.constraintViolations.map {
            "${it.propertyPath}: ${it.message}"
        }
        val response = mapOf("errors" to errors)
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidArgumentException::class)
    fun handleInvalidArgumentExceptions(ex: InvalidArgumentException, request: WebRequest): ResponseEntity<Any> {

        logger.info("An error occurred here ${ex.message}")

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.message)
    }

    @ExceptionHandler(ItemNotFoundException::class)
    fun handleItemNotFoundExceptions(ex: ItemNotFoundException, request: WebRequest): ResponseEntity<Any> {

        logger.info("An error occurred here ${ex.message}")

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.message)
    }

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
