package com.trivago.accomodationlisting.annotations

import com.trivago.accomodationlisting.validators.ItemDTOCategoryValidator
import com.trivago.accomodationlisting.validators.ItemDTORatingRangeValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ItemDTOCategoryValidator::class])
annotation class ValidateItemDTOCategory (
    val message: String = "itemDTO.category must be one of the following hotel, alternative, hostel, lodge, resort, guest-house",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
) {
}