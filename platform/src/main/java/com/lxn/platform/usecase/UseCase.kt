package com.lxn.platform.usecase

import com.lxn.platform.functional.Either
import com.lxn.platform.exception.Failure
import kotlinx.coroutines.*

/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:16 - 10/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None
}