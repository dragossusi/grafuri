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
fun Graph.dijkstra(s: Int): IntArray {
    val n = size
    val S = IntArray(n)
    val t = IntArray(n)
    val tata = IntArray(n)
    var min: Int
    for (i in 0 until n) {
        S[i] = 0
        t[i] = Integer.MAX_VALUE
        tata[i] = Integer.MAX_VALUE
    }
    t[s] = 0
    tata[s] = 0
    do {
        var x: Int = -1
        min = Integer.MAX_VALUE
        for (i in 0 until n) {
            if (S[i] == 0 && t[i] < min) {
                min = t[i]
                x = i
            }
        }
        if (min < Integer.MAX_VALUE) {
            S[x] = 1
            for (i in 0 until n) {
                if (S[i] == 0 && this[x, i] < Integer.MAX_VALUE) {
                    if (t[i] > t[x] + this[x, i]) {
                        t[i] = t[x] + this[x, i]
                        tata[i] = x
                    }
                }
            }
        }
    } while (min < Integer.MAX_VALUE)
    return t
}