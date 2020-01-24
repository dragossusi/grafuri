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
fun Graph.royFloyd(): Graph {
    println("Roy floyd")
    val c = Graph(
        Array(size) {
            IntArray(size)
        }
    )

    this.matrix.forEachIndexed { i, row ->
        row.forEachIndexed { j, value ->
            c[i, j] = value
        }
    }
    for (k in 0 until size) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (c[i, k] + c[k, j] < c[i, j]) c[i, j] = c[i, k] + c[k, j]
            }
        }
    }
    println("Finished Roy floyd")
    return c
}