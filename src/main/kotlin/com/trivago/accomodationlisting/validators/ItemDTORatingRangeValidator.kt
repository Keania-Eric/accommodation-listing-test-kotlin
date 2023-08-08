package com.trivago.accomodationlisting.validators

import com.trivago.accomodationlisting.annotations.ValidateItemDTORatingRange
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

class ItemDTORatingRangeValidator: ConstraintValidator<ValidateItemDTORatingRange, Int> {


    override fun initialize(constraintAnnotation: ValidateItemDTORatingRange?) {

    }

    @Min(0, message = "Value must be greater than or equal to 0")
    @Max(5, message = "Value must be less than or equal to 5")
    override fun isValid(value: Int?, context: ConstraintValidatorContext?): Boolean {
        return value in 0..5
    }
}