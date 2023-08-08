package com.trivago.accomodationlisting.validators

import com.trivago.accomodationlisting.annotations.ValidateItemDTOName
import com.trivago.accomodationlisting.enums.BlackListWords
import com.trivago.accomodationlisting.exceptions.InvalidArgumentException
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class ItemDTONameValidator: ConstraintValidator<ValidateItemDTOName, String> {

    override fun initialize(constraintAnnotation: ValidateItemDTOName?) {
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {

        val blackListedWords = enumValues<BlackListWords>().map{it.word}
        for(word in blackListedWords) {
            if (value != null) {
                if(value.contains(word, ignoreCase = true)) {
                    return false
                                    }
            }
        }

        return true

    }
}