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
fun Graph.royWarshall(): Graph {
    println("Roy warshall")
    val d = Graph(
        Array(size) {
            IntArray(size)
        }
    )
    this.matrix.forEachIndexed { i, row ->
        row.forEachIndexed { j, value ->
            d[i, j] = if (value > 0) 1
            else 0
        }
    }
    for (k in 0 until size) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (d[i, j] == 0) d[i, j] = d[i, k] * d[k, j]
            }
        }
    }
    println("Finished Roy Warshall")
    return d
}