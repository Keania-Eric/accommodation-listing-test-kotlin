package com.trivago.accomodationlisting.validators

import com.trivago.accomodationlisting.annotations.ValidateItemDTOCategory
import com.trivago.accomodationlisting.enums.HotelCategory
import com.trivago.accomodationlisting.exceptions.InvalidArgumentException
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class ItemDTOCategoryValidator: ConstraintValidator<ValidateItemDTOCategory, String> {


    override fun initialize(constraintAnnotation: ValidateItemDTOCategory?) {

    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val categories = enumValues<HotelCategory>().map{it.category}

        return categories.any{it.equals(value, ignoreCase = true)}
    }
}