package com.application.streamchatapplication.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.streamchatapplication.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.call.await
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val client: ChatClient
) : ViewModel() {

    private val _loginEvent = MutableSharedFlow<LogInEvent>()
    val logInEvent = _loginEvent.asSharedFlow()

    //Check user Validation
    private fun isValidUserName(userName: String) =
        userName.length > Constants.MIN_USERNAME_LENGTH

    fun connectUser(userName: String) {
        val trimmedUserName = userName.trim() //remove the spaces
        viewModelScope.launch {
            if (isValidUserName(trimmedUserName)) {
                val result =
                    client.connectGuestUser(
                        userId = trimmedUserName,
                        username = trimmedUserName
                    ).await()
                if (result.isError) {
                    //show the error message we are sending this message using sharedFlow
                    _loginEvent.emit(
                        LogInEvent.ErrorLogIn(
                            result.error().message ?: "Unknown error"
                        )
                    )
                    return@launch
                }
                _loginEvent.emit(LogInEvent.Success)
            } else {
                _loginEvent.emit(LogInEvent.ErrorInputTooShort)
            }
        }
    }

    sealed class LogInEvent {
        object ErrorInputTooShort : LogInEvent()
        data class ErrorLogIn(val error: String) : LogInEvent()
        object Success : LogInEvent()
    }
}