package pe.com.bcp.reclamowow.core.base

import java.lang.Exception

abstract class BaseUseCase<T> {

    @Throws(Exception::class)
    abstract suspend fun execute():T

    open suspend fun execute(dataToValidate: T): T {
        return dataToValidate
    }
}