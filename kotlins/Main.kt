package kotlins

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import java.lang.Exception

suspend fun main() {
    val model = ViewModel()
    model.foo().join()
}

class Fragment(viewModel: ViewModel) : CoroutineScope by CoroutineScope(SupervisorJob()){
    fun onStop(){
        coroutineContext.cancelChildren()
    }

    fun onDestroyView(){
        coroutineContext.cancel()
    }
}

class ViewModel : CoroutineScope by CoroutineScope(SupervisorJob()) {


    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println(throwable.message)
    }

    fun bar() = launch {
        delay(500)
        println("barring ... ")
    }

    fun foo() = GlobalScope.launch(handler) {
      throw Exception("oopsa")
    }
    fun onCleared() {
        coroutineContext.cancel()
    }
}
