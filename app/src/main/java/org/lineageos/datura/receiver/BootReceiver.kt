/*
 * SPDX-FileCopyrightText: 2024 Lineage-OS-Special-Project (LOSP)
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.datura.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import lineageos.providers.LineageSettings
import org.lineageos.datura.service.DaturaService

@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {

    private val TAG = BootReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {
        if (LineageSettings.Secure.getInt(
                context?.contentResolver,
                LineageSettings.Secure.DEFAULT_RESTRICT_NETWORK_DATA,
                0
            ) == 1
        ) {
            context?.startForegroundService(Intent(context, DaturaService::class.java))
        }
    }
}
