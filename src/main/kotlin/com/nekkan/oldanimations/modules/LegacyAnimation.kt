package com.nekkan.oldanimations.modules

import com.nekkan.oldanimations.settings.Checkbox
import com.nekkan.oldanimations.settings.Identifier

interface LegacyAnimation {

    val identifier: Identifier

    val isEnabled: Checkbox

    fun disable() {
        /* no-op */
    }

}
