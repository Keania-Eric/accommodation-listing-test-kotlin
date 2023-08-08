package com.trivago.accomodationlisting.validators

import com.trivago.accomodationlisting.annotations.ValidateItemDTOImage
import com.trivago.accomodationlisting.annotations.ValidateItemDTORatingRange
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.net.URL

class ItemDTOImageValidator: ConstraintValidator<ValidateItemDTOImage, String> {

    override fun initialize(constraintAnnotation: ValidateItemDTOImage?) {

    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return  try {
            URL(value)
            true
        }catch (e: Exception) {
            false
        }
    }
}