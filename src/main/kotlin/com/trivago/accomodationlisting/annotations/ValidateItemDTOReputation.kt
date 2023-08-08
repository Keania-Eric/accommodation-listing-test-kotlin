package com.trivago.accomodationlisting.annotations

import com.trivago.accomodationlisting.validators.ItemDTORatingRangeValidator
import com.trivago.accomodationlisting.validators.ItemDTOReputationValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import jakarta.validation.ReportAsSingleViolation
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [ItemDTOReputationValidator::class])
@ReportAsSingleViolation
annotation class ValidateItemDTOReputation (
    val message: String = "itemDTO.reputation must be within the range of 0 and 1000",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
) {
}