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
fun Graph.strongComponents(): Int {
    println("Starting strong components")
    val scc = IntArray(size)
    var nrsc = 0
    val roy = this.royWarshall()
    for (i in 0 until size) {
        if (scc[i] == 0) {
            ++nrsc
            scc[i] = nrsc
            for (j in i + 1 until size) {
                if (scc[j] == 0 && roy[i, j] == 1 && roy[j, i] == 1)
                    scc[j] = nrsc
            }
        }
    }
    println("Finished strong components: $nrsc")
    return nrsc
}