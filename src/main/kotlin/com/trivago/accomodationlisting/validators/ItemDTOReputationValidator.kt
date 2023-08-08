package com.trivago.accomodationlisting.validators

import com.trivago.accomodationlisting.annotations.ValidateItemDTORatingRange
import com.trivago.accomodationlisting.annotations.ValidateItemDTOReputation
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

class ItemDTOReputationValidator : ConstraintValidator<ValidateItemDTOReputation, Int> {

    override fun initialize(constraintAnnotation: ValidateItemDTOReputation?) {

    }

    @Min(0, message = "Value must be greater than or equal to 0")
    @Max(1000, message = "Value must be less than or equal to 1000")
    override fun isValid(value: Int?, context: ConstraintValidatorContext?): Boolean {
       return value in 0..1000
    }
}