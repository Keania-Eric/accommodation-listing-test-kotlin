package com.trivago.accomodationlisting.annotations

import com.trivago.accomodationlisting.validators.ItemDTONameValidator
import com.trivago.accomodationlisting.validators.ItemDTORatingRangeValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import jakarta.validation.ReportAsSingleViolation
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ItemDTORatingRangeValidator::class])
@ReportAsSingleViolation
annotation class ValidateItemDTORatingRange(
    val message: String = "itemDTO.range must be within the range of 0 and 5",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
) {
}