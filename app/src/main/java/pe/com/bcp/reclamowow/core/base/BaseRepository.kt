package pe.com.bcp.reclamowow.core.base

import pe.com.bcp.reclamowow.R

class BaseRepository {
}

sealed class Response<out T> {
    data class Success<out T>(val successData: T): Response<T> ()
    data class Failure<out T>(val errorData: R): Response<Nothing>()
}