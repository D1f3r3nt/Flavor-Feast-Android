package com.keepcoding.flavorfeast.model.enums

import java.lang.Exception

class NoDataException: Exception()

class BadRequestException(code: Int) : Exception(code.toString())