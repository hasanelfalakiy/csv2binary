/**
 * This file is part of csv2binary.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * @programmed by: Andi Hasan A
 * @github: https://github.com/hasanelfalakiy
 */

package com.andihasan7.csv2binary.dataclass

data class Nutation2000bCsvRow(
    val i: Int = 0,
    val vL: Double = 0.0,
    val vL1: Double = 0.0,
    val vF: Double = 0.0,
    val vD: Double = 0.0,
    val vOmega: Double = 0.0,
    val vA: Double = 0.0,
    val vA1: Double = 0.0,
    val vA2: Double = 0.0,
    val vB: Double = 0.0,
    val vB1: Double = 0.0,
    val vB2: Double = 0.0
)
