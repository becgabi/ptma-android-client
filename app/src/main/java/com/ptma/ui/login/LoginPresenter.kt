package com.ptma.ui.login

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class LoginPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}