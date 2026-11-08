/*
 * SPDX-FileCopyrightText: 2023 Lineage-OS-Special-Project (LOSP)
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.datura.models

data class Header(
    val name: String = String(),
    override val type: Type = Type.HEADER
) : DaturaItem
