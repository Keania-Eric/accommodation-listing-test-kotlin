package com.trivago.accomodationlisting.annotations


import com.trivago.accomodationlisting.validators.ItemDTOImageValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ItemDTOImageValidator::class])
annotation class ValidateItemDTOImage (
    val message: String = "itemDTO.image must be a valid URL",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
) {
}