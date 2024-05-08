package com.keepcoding.flavorfeast.model.enums

sealed class ViewState

class IdleState : ViewState()
class LoadingState : ViewState()
class ErrorState(val msg: String) : ViewState()
class OKState(val element: Any) : ViewState()