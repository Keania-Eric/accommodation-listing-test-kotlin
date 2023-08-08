package com.trivago.accomodationlisting.annotations

import com.trivago.accomodationlisting.validators.ItemDTONameValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ItemDTONameValidator::class])
annotation class ValidateItemDTOName(
    val message: String = "itemDTO.name must not contain Free, Offer, Book, Website",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)  {

}