package alg

import Graph

/**
 * grafuri
 *
 * Copyright (C) 2020  Rachieru Dragos-Mihai
 *
 * grafuri is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * grafuri is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with grafuri.  If not, see [License](http://www.gnu.org/licenses/) .
 *
 */
fun Graph.prim(): IntArray {
    val S = IntArray(size)
    val t = IntArray(size)
    val tata = IntArray(size)
    S[0] = 0
    var cost = 0
    for (i in 1 until size) {
        S[i] = 0
        t[i] = this[i, 0]
        tata[i] = 1
    }
    for (l in 0 until size - 1) {
        var y = -1
        var min = Integer.MAX_VALUE
        for (i in 1 until size) {
            if (S[i] == 0 && t[i] < min) {
                min = t[i]
                y = i
            }
        }
        S[y] = 1
        var x = tata[y]
        cost += this[x, y]
        for (i in 1 until size) {
            if (S[i] == 0 && t[i] > this[i, y]) {
                t[i] = this[i, y]
                tata[i] = y
            }
        }
    }
    return t
}